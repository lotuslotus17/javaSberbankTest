Feature: Иконки социальных сетей
  Как юзер
  Я должен иметь возможность видеть иконки социальных сетей на странице малого бизнеса

  @Category
  Scenario: юзер может увидеть иконки соц. сетей
    Given юзер открывает главную страницу
    Then открылась страница «Сбербанк» - Частным клиентам
    When юзер переходит на страницу Малый бизнес
    Then открылась страница «Сбербанк» - Малый бизнес
    When юзер меняет город на другой
    Then город изменился на другой
    When юзер скролит в самый низ страницы
    Then все иконки социальных сетей видны юзеру