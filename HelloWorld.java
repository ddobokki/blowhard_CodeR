// Factory interface for creating message printers
interface MessagePrinterFactory {
    MessagePrinter createMessagePrinter();
}

// Abstract class for message printers
abstract class MessagePrinter {
    // Template method pattern: defines the basic flow of creating and printing a message.
    // This ensures the overall process is consistent and allows subclasses to define specific message content.
    public void printMessage() {
        String message = createMessage();
        System.out.println(message);
    }

    // Abstract method to create a message.
    // Subclasses must implement this method to provide specific message content.
    protected abstract String createMessage();
}

// Concrete class for printing "Hello, World!" message
class HelloWorldPrinter extends MessagePrinter {
    @Override
    protected String createMessage() {
        return "Hello, World!";
    }
}

// Concrete factory class for creating HelloWorldPrinter instances
class HelloWorldPrinterFactory implements MessagePrinterFactory {
    @Override
    public MessagePrinter createMessagePrinter() {
        return new HelloWorldPrinter();
    }
}

// Client code demonstrating the usage of the factory and printer
public class Main {
    public static void main(String[] args) {
        // Create a factory object for HelloWorldPrinter
        MessagePrinterFactory factory = new HelloWorldPrinterFactory();

        // Use the factory to create a message printer object and print the message
        MessagePrinter printer = factory.createMessagePrinter();
        printer.printMessage();
    }
}

// The above code is highly extensible due to its use of design patterns:
// 1. **Abstract Factory Pattern**: Allows easy addition of new types of message printers by creating new factory classes.
//    - To add a new type of message printer, create a new class that extends MessagePrinter and a corresponding factory class that implements MessagePrinterFactory.
// 2. **Template Method Pattern**: Ensures a consistent method for printing messages while allowing subclasses to define specific message content.
//    - To change the message content, create a new subclass of MessagePrinter and override the createMessage method.
