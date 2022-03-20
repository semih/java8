import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
Method References
Method reference can be used as a shorter and more readable alternative for a lambda expression which only calls an existing method.
There are four variants of method references.
https://www.baeldung.com/java-8-new-features
*/
public class MethodReferences {
    private List<String> list;

    public MethodReferences() {
        list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
    }

    public void execute() {
        // 1. Reference to a Static Method
        boolean isReal = list.stream().anyMatch(u -> User.isRealUser(u));
        System.out.println(isReal);         // true
        isReal = list.stream().anyMatch(User::isRealUser);
        System.out.println(isReal);         // true

        // 2. Reference to an Instance Method
        User user = new User();
        boolean isLegalName = list.stream().anyMatch(user::isLegalName);
        System.out.println(isLegalName);    // true

        // 3. Reference to an Instance Method of an Object of a Particular Type
        long count = list.stream().filter(String::isEmpty).count();
        System.out.println(count);          // 2

        // 4. Reference to a Constructor
        Stream<User> stream = list.stream().map(User::new);
    }

    public static void main(String[] args) {
        MethodReferences methodReferences = new MethodReferences();
        methodReferences.execute();
    }
}