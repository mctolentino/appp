class Resource {
    void open() { println 'Groovy Open' }

    void close() { println 'Close' }

    void operationOne() { println 'Operation 1' }

    void operationTwo() { println 'Operation 2' }

    static void create(closure) { // closure is a function that can be passed around
        def resource = new Resource()
        try {
            resource.open()
            closure(resource)
        } finally {
            resource.close()
        }
    }
}

Resource.create() { resource ->
    resource.operationOne()
    resource.operationTwo()
}