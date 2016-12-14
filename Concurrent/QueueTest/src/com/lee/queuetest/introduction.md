 BlockingQueue是个接口，有如下实现类：
       1. ArrayBlockQueue：一个由数组支持的有界阻塞队列。此队列按 FIFO（先进先出）原则对元素进行排序。创建其对象必须明确大小，像数组一样。
       2. LinkedBlockQueue：一个可改变大小的阻塞队列。此队列按 FIFO（先进先出）原则对元素进行排序。创建其对象如果没有明确大小，默认值是Integer.MAX_VALUE。链接队列的吞吐量通常要高于基于数组的队列，但是在大多数并发应用程序中，其可预知的性能要低。 

       3. PriorityBlockingQueue：类似于LinkedBlockingQueue，但其所含对象的排序不是FIFO，而是依据对象的自然排序顺序或者是构造函数所带的Comparator决定的顺序。

       4. SynchronousQueue：同步队列。同步队列没有任何容量，每个插入必须等待另一个线程移除，反之亦然。