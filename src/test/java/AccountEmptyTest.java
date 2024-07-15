import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static constants.Errors.EXCEPTION_MESSAGE_FOR_CHECK_NAME;

@RunWith(Parameterized.class)
public class AccountEmptyTest {


    @Parameterized.Parameter
    public String name;

    @Parameterized.Parameters(name = "{index} Сценарий проверки с имененм: {0}.")
    public static Object[][] data() {
        return new Object[][] {
                { "" },
                { null }


        };
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    @DisplayName("Проверка имени с пустым или null значением")
    @Description("Проверка соответсвие имени параметрам:" +
            "\n 1. в строке не меньше 3 и не больше 19 символов," +
            "\n 2. в строке есть только один пробел," +
            "\n 3. пробел стоит не в начале и не в конце строки.")
    public void checkName() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage(EXCEPTION_MESSAGE_FOR_CHECK_NAME);
        Account account = new Account(name);
        account.checkNameToEmboss();
    }

}
