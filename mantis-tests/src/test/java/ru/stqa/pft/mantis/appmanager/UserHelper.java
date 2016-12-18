package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

/**
 * Created by User on 18.12.2016.
 */
public class UserHelper  extends HelperBase {
    public UserHelper(ApplicationManager app){
        super(app);
    }

    public void openUserDetailsOnManageUsersPage(UserData user)
    {
        wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + user.getId() + "']")).click();
    }

    public void initResetPassword()
    {
        click(By.cssSelector("input[value='Сбросить пароль']"));
    }

    public void changePassword(String passwordLink, String newPassword)
    {
        wd.get(passwordLink);
        type(By.name("password"), newPassword);
        type(By.name("password_confirm"), newPassword);
        click(By.cssSelector("input[value='Изменить учетную запись']"));
    }




}
