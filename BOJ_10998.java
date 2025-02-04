class ConfigurationManager {
    private static volatile ConfigurationManager instance;

    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }
}

interface Parser {
    String parse(String data);
}

class XMLParser implements Parser {
    public String parse(String data) {
        return "Parsed XML data: " + data;
    }
}

class JSONParser implements Parser {
    public String parse(String data) {
        return "Parsed JSON data: " + data;
    }
}

class ParserFactory {
    public static Parser createParser(String type) {
        if ("XML".equalsIgnoreCase(type)) {
            return new XMLParser();
        } else if ("JSON".equalsIgnoreCase(type)) {
            return new JSONParser();
        }
        throw new IllegalArgumentException("Unsupported parser type");
    }
}

enum DatabaseConnection {
    INSTANCE;
    
    public void connect() {
        System.out.println("Connected to database");
    }
}

public class IntegratedExample {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        System.out.println("Config Manager Instance: " + configManager);

        Parser xmlParser = ParserFactory.createParser("XML");
        Parser jsonParser = ParserFactory.createParser("JSON");
        System.out.println(xmlParser.parse("<root/>"));
        System.out.println(jsonParser.parse("{\"key\":\"value\"}"));

        DatabaseConnection dbConn = DatabaseConnection.INSTANCE;
        dbConn.connect();
    }
}