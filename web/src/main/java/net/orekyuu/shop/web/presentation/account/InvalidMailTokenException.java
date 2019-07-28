package net.orekyuu.shop.web.presentation.account;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 存在しないトークンなどがパラメータに与えられたときの例外
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidMailTokenException extends RuntimeException {
}
