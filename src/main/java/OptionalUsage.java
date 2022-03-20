import model.Address;
import model.OptionalAddress;
import model.OptionalUser;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* Optional<T>
* Before Java 8 developers had to carefully validate values they referred to, because of a possibility of throwing the NullPointerException (NPE).
* All these checks demanded a pretty annoying and error-prone boilerplate code.
*
* Java 8 Optional<T> class can help to handle situations where there is a possibility of getting the NPE.
* It works as a container for the object of type T. It can return a value of this object if this value is not a null.
* When the value inside this container is null it allows doing some predefined actions instead of throwing NPE.
*
* https://www.baeldung.com/java-8-new-features
* */
public class OptionalUsage {

    private List<String> list;

    public OptionalUsage() {
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

        // Creation of the Optional<T>
        Optional<String> optionalEmpty = Optional.empty();
        System.out.println(optionalEmpty.isPresent());  // false

        String str = "value";
        Optional<String> optional = Optional.of(str);
        System.out.println(optional.get());             // value

        Optional<String> optionalNullable = Optional.ofNullable(str);
        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println(optionalNullable.get());     // value
        System.out.println(optionalNull.isPresent());   // false
        // Creation of the Optional<T>


        List<String> listOpt = Optional.of(list).orElse(new ArrayList<>());
        List<String> listNull = null;
        List<String> listOptNull = Optional.ofNullable(listNull).orElse(new ArrayList<>());
        System.out.println(listOpt == list);            // true
        System.out.println(listOptNull.isEmpty());      // true

        Optional<User> user = Optional.ofNullable(getUser());
        String result = user.map(User::getAddress).map(Address::getStreet).orElse("not specified");
        System.out.println(result);                     // 1st Avenue

        Optional<OptionalUser> optionalUser = Optional.ofNullable(getOptionalUser());
        String resultOpt = optionalUser.flatMap(OptionalUser::getAddress).flatMap(OptionalAddress::getStreet).orElse("not specified");
        System.out.println(resultOpt);                  // 1st Avenue

        Optional<User> userNull = Optional.ofNullable(getUserNull());
        String resultNull = userNull.map(User::getAddress).map(Address::getStreet).orElse("not specified");
        System.out.println(resultNull);                 // not specified

        Optional<OptionalUser> optionalUserNull = Optional.ofNullable(getOptionalUserNull());
        String resultOptNull = optionalUserNull.flatMap(OptionalUser::getAddress).flatMap(OptionalAddress::getStreet).orElse("not specified");
        System.out.println(resultOptNull);              // not specified
    }

    private User getUser() {
        User user = new User();
        Address address = new Address();
        address.setStreet("1st Avenue");
        user.setAddress(address);
        return user;
    }

    private OptionalUser getOptionalUser() {
        OptionalUser user = new OptionalUser();
        OptionalAddress address = new OptionalAddress();
        address.setStreet("1st Avenue");
        user.setAddress(address);
        return user;
    }

    private OptionalUser getOptionalUserNull() {
        OptionalUser user = new OptionalUser();
        OptionalAddress address = new OptionalAddress();
        address.setStreet(null);
        user.setAddress(address);
        return user;
    }

    private User getUserNull() {
        User user = new User();
        Address address = new Address();
        address.setStreet(null);
        user.setAddress(address);
        return user;
    }

    public static void main(String[] args) {
        OptionalUsage optionalUsage = new OptionalUsage();
        optionalUsage.execute();
    }
}
