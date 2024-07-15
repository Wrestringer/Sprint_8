import static constants.Errors.EXCEPTION_MESSAGE_FOR_CHECK_NAME;

public class Account {

    private final String name;

    public Account(String name)  {
        this.name = name;
    }

    public boolean checkNameToEmboss() throws Exception {
        boolean correctName = false;

        if ( this.name == null || this.name.isEmpty()) {
            throw new Exception(EXCEPTION_MESSAGE_FOR_CHECK_NAME);
        }
        else {

            long countSpaces = this.name.chars().filter(ch -> ch == ' ').count();
            correctName = this.name.length() >= 3 & this.name.length() <= 19 & !this.name.startsWith(" ") & !this.name.endsWith(" ") & countSpaces == 1;
            return correctName;
        }
    }

}