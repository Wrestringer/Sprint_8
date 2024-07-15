import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountNotEmptyTest {

    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public boolean correctName;

    @Parameterized.Parameters(name = "{index} Сценарий проверки с имененм: {0}. Ожидаемый результат: {1}")
    public static Object[][] data() {
        return new Object[][] {
                { " ", false },
                { "ав", false },
                { " Авель Густав", false },
                { "АвельГустав", false },
                { "Авель Густав ", false },
                { "Авельсон Густоввичев", false },
                { "Ю А", true },
                { "Авельсон Густовичев", true }


        };
    }


    @Test
    @DisplayName("Проверка имени с не пустыми значениями")
    @Description("Проверка соответсвие имени параметрам:" +
            "\n 1. в строке не меньше 3 и не больше 19 символов," +
            "\n 2. в строке есть только один пробел," +
            "\n 3. пробел стоит не в начале и не в конце строки.")
    public void checkName() throws Exception {
        Account account = new Account(name);
        Assert.assertEquals(correctName, account.checkNameToEmboss());
    }

}
