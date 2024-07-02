package units.classes;

// --> Interface <--
// An interface is a reference type, similar to a class, that is used to specify a set of abstract methods that a class must implement.
// Interfaces are used to achieve abstraction and multiple inheritance in Java.
// An interface primarily contains abstract methods, which are method signatures without bodies.
// Implementing classes must provide the actual implementation for these methods.

public interface Caster {
    void castSpell(String spell);
}
