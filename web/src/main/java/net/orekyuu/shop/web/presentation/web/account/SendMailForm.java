package net.orekyuu.shop.web.presentation.web.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SendMailForm {
    @Email
    @Size(max = 20)
    @NotEmpty
    public String mail;
}
