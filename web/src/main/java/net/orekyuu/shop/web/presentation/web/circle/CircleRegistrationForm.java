package net.orekyuu.shop.web.presentation.web.circle;


import net.orekyuu.shop.core.domain.model.circle.CircleHomePage;
import net.orekyuu.shop.core.domain.model.circle.CircleName;
import net.orekyuu.shop.core.domain.model.circle.CircleSupportMailAddress;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CircleRegistrationForm {
    @Size(min = 3, max = 40)
    public String name = "";
    @Email
    @NotBlank
    public String supportMail = "";
    @URL
    public String homepage = "";

    CircleName circleName() {
        return new CircleName(name);
    }

    CircleSupportMailAddress supportMailAddress() {
        return new CircleSupportMailAddress(supportMail);
    }

    CircleHomePage homePage() {
        return new CircleHomePage(homepage);
    }
}
