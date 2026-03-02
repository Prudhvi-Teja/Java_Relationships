
Event Driven Architecture(EDA):
  Considered it as system design style where
    - Services do not call each other directly.
    - Instead, Services emit events and other services react to those events



EDA Models (Event Driven architecture)

challenges:
1. Eventual consistency
2. Duplicate Events
3. Ordering problems
4. Schema evloution
5. Debugging complexity
6. Poision Message
7. Operaional Overhead:
     Must Monitor for:
     - Consumer lah
     - Throughput
     - Partition, queues etc
  
Use Case of EDA :
1. 1 event -> N Consumer
2. Long Running Business workflow
   Ex: Order -> payment -> shipment -> delievery
3. Eventual Consistency
4. Real time analytics
   Data need to be continously processing
