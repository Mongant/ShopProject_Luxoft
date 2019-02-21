//ДЗ реализовать в клаентДао правильный синглтон
// Написать ряд валидаторов
// 1. Проверяет правильность ввода емаил адреса
// 2. Проверка номера тел в формате +38093ххххххх одязательно правильный код оператора и введено 10 цифр
//067
//097
//050
//3. если админ или пользователь добавляет клиента с таким же номером телефона, выбрасываем ексепшн

//Меню Добавить продукт
//        Изменить продукт
//        Удалить продукт
//
//        Изменить ордер
//        Удалить ордер
//        показать лист Ордеров

//Клиент
//        регистрировать
//        изменить - показать данные клиента
//        создать заказ
//        посмотреть список своих заказов
//        посмотреть свои данные
//        посмотреть список продуктов
//

package com.gorbunov;

import com.gorbunov.dao.impl.ClientDaoImpl;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductService;
import com.gorbunov.services.impl.ClientServiceImpl;
import com.gorbunov.services.impl.OrderServiceImpl;
import com.gorbunov.services.impl.ProductServiceImpl;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.validator.ValidationService;
import com.gorbunov.validator.ValidationServiceImpl;
import com.gorbunov.view.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException, BusinessException {
        ValidationService validationService = new ValidationServiceImpl();
        ClientService clientService = new ClientServiceImpl(ClientDaoImpl.getInstance(), validationService);
        ProductService productService = new ProductServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        MainMenu mainMenu = new MainMenu(bf, clientService, productService, orderService);
        mainMenu.showMenu();
    }
}