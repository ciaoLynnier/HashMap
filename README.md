### 基本思路
1、存储put()：
* Map有一个封装的内部接口Entry<K,V>，用来将key和value封装成键值对对象
* 键值对对象根据计算的hashcode值进行存储
* hashmap的特点
  * key不能重复
  * 当key重复时，会把原有的键值对替换成新的键值对

2、取值get()：
* 先调用hashcode方法进行计算，判断是否存在
  * 存在则在链表中进行equals方法一一比较他们的key
  * key值不重复
---
### 具体操作
1、首先需要一个Map接口，其中定义我们的put()、get()、hashcode()等方法`FakeMap.java`

2、需要一个Entry类，用来用我们传入的键值对生成键值对对象`Entry.java`

3、需要一个Map的实现类，用来实现Map中的各个方法`FakeHashMap.java`

4、最后写一个测试类，测试我们自己手搓的hashmap`test.jaja`
* 传入三个键值对，其中前两个的key值相同，看看是否会自己更新value值

5、补充：HashMap还有很多其他的方法，我这里没有全部手撕下来，但是可以根据put和get的思路来做
* 具体实现的话就是在接口中定义新的方法，并且在实现类中实现再去测试就完事了
