//Design Patterns and Principles	
//Exercise 2 - Implementing the Factory Method Pattern
abstract class Document {
    public abstract String getType();
    public void open() {
        System.out.println("Opening " + getType());
    }
}

// concrte document types
class WordDocument extends Document {
    public String getType() {
        return "Word Document";
    }
}

class PdfDocument extends Document {
    public String getType() {
        return "PDF Document";
    }
}

class ExcelDocument extends Document {
    public String getType() {
        return "Excel Spreadsheet";
    }
}

// abstract factory
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// concrete factories
class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// testtt class
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // can switch the factory to create diff doc types

        DocumentFactory factory;

        factory = new WordFactory();
        Document doc1 = factory.createDocument();
        doc1.open();

        factory = new PdfFactory();
        Document doc2 = factory.createDocument();
        doc2.open();

        factory = new ExcelFactory();
        Document doc3 = factory.createDocument();
        doc3.open();
    }
}
