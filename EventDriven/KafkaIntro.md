
Kafka:
It's a distributed event streaming platform that allow us to
  - publish events
  - store events
  - subscribe to events

Producer:
 - Producer is an application that publishes event to kafka
 - producer does not care who will consume this event

Topic:
 - Considered Topic as category or Folder to which events are published
 - Many Producers can write to same topic

Partition:
 - A Physical, Ordered and append-only log that is part of topic
 - A topic can have many partitions
 - Physical: Events are actually stored on the disk inside the partition.
 - Ordered: Events are written sequentially and assigned increment offsets, consumer read then in offset Order
 - Each partition maintain  its next offset counter
 - with in a single partition - Order is guranteed
 - But Doesnot guarantees ORDER globally (across multiple partitions of the Topic)
 - This partition log file is divided into segments
 - Consumer can say, I want to read from partition0 of Order events -> offset 550 to 800
 - Index file per segment
 -   - Not  every offset is indexed
     - Instead it index every N bytes, mean after N bytess written to log file, It created 1 index row 
 - This saves memory and aslo helps in faster lookup

Producer can pick one of the different algorithm to decide which partition of an topic an event should be sent to
  - Key-based partitioning
  - Round-robin
  - Custon Partitoning

Broker:
- A broker is single kafka server instance
- A broker is the onw which actually stores data and servers client (Producer and Consumer).
- A broker store some partitions of some topics
  
Important Note
Topics and Paritions are distributed across multiple brokers, That's why broker stores only some partitions of some topics
 - So, It don't hold all Topics
 - also, it do not hold all partitions of the topic


 Desciption:

What is Kafka?
Kafka is described as a distributed event streaming platform. This platform enables users to publish events, store these events, and subscribe to (consume) them. The term "streaming" signifies Kafka's ability to store events, allowing them to be replayed later if needed.

Producer
A producer is essentially an application responsible for publishing events to Kafka. A key characteristic highlighted is that producers operate independently; they do not concern themselves with which consumers will eventually process the events.

Topic
Topics are presented as categories or folders to which events are published. They serve as a logical grouping mechanism for events. Multiple producers can publish events to the same topic.

Partition and Segments

Partitions are defined as physical, ordered, and append-only logs where events are actually stored on disk. A single topic can be comprised of multiple partitions.
Event Ordering: Within a partition, events are written sequentially and assigned incrementally increasing offsets. Each partition maintains its own independent offset counter. While order is strictly guaranteed within a single partition (events are written and read in sequential offset order), global order across different partitions is not guaranteed. This is because each partition maintains its own independent counter.
Append-Only Principle: New events are always appended to the end of a partition's log file, meaning data is only added, never modified in place.
Segments: To enhance search efficiency, particularly when consumers request specific offset ranges, a partition's log file is further divided into smaller segments.
Index File: Each segment has an associated index file. This index file maps specific offsets to their physical positions within the segment's log file, which significantly speeds up data lookup. It's important to note that not every offset is indexed; instead, an index entry is created after every 'n' bytes, with 'n' being a configurable value.
Producer Partitioning Logic: The video explains how producers determine which partition an event will be sent to, outlining three main algorithms:
Key-based partitioning: Events with the same key are guaranteed to go to the same partition. This is typically determined by computing a hash of the key modulo the number of partitions.
Round-robin partitioning: If a producer does not provide a key for an event, Kafka will distribute events across the available partitions in a round-robin fashion.
Custom partitioning: Users can also define their own custom logic for partitioning events based on specific criteria.
Broker
A broker is identified as a single instance of a Kafka server. It functions as the actual server responsible for storing data and serving client requests. A crucial point emphasized is that a broker stores only some partitions of some topics. This is because topics and partitions are designed to be distributed across multiple brokers to ensure scalability and fault tolerance, a concept to be further explored in discussions about Kafka clusters.
  
