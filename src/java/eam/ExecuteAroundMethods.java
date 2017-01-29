package eam;

public class ExecuteAroundMethods {

    public static void main(String[] args) {
        Resource.create(new UseResource() {
            @Override
            public void use(Resource resource) {
                resource.operationOne();
                resource.operationTwo();
            }
        });
    }

}

class Resource {
    private void open() {
        System.out.println("Opened");
    }
    private void close() {
        System.out.println("Closed");
    }

    public void operationOne() {
        System.out.println("Operation 1");
    }

    public void operationTwo() {
        System.out.println("Operation 2");
    }

    public static void create(UseResource useResource) {
        Resource resource = new Resource();
        try {
            resource.open();
            useResource.use(resource);
        } finally {
            resource.close();
        }
    }
}

interface UseResource {
    public void use(Resource resource);
}