
### Why is a Queue the appropriate data structure for a message broker rather than a Stack? What would happen to the order of messages if you used a Stack instead?
Queue is a more appropriate data structure for a message broker rather than a Stack because it will process what it receives and sends out messages in the order that it gets it. A stack is last in first out(LIFO) so the requests will be printed backward while a Queue will be first in first out (FIFO) so it will be printed in order.

### In this phase, you are adding failed messages back to the end of the queue. How does this affect the “fairness” of the system?
It affects the fairness of the system because the other messages are allowed the chance to process before it the failed attempt is allowed to try again.

### Explain the lifecycle of a “poison message” in your system. From the moment it is first enqueued to the moment it lands in the DLQ, what happens to its state and its position in the various queues?
A poison message will try to run after three time of running and failing because it will the  is not possible to succeed  it will then move to the DLQ until it the user is ready to view and delete it.