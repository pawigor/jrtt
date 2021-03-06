# jrtt
Java Rush Test Task

## Компиляция
``` shell
mvn clean package
```
## Запуск

```shell
java -jar ./target/jrtt.jar
```
## NB

Вариант задачи 2 *TODOList*.

Для реализации задачи был выбран ***Spring Boot***, соответвенно использовались примеры с офсайта.

Требования задачи, считаю удовлетворенными: используется Maven, Spring, Hibernate, Tomcat, Mysql и Vaadin, т.ч. не сочтите за читерство :)

## Условия
На выбор дается 2 задания (плюс выбор front end framework за вами, из списка предлагаемых).

Результат выкладывайте на github или bitbucket –заодно познакомитесь с ними.

После выполнения задания просьба зайти в свой профиль на ДжаваРаш и заполнить ссылку на решенное задание.

Файлы проекта .idea и скомпиленные классы в output или target выкладывать не надо.

Ранее задание было строго на GWT, и только одно (CRUD).

Требуемые технологии:
* Maven (для сборки проекта)
* Spring
* Hibernate (для маппинга сущностей приложения на БД, и работы с БД)
* Tomcat 7,8 (для тестирования своего приложения)
* Mysql (база данных).Для упрощения тестирования называйте все свою базу test, с логином и паролем root (нам  не нужно будет для тестирования создавать кучу лишних и ненужных баз)
* Frontend: angular.js or Vaadin (можно и GWT, но будут сложности) or ZK framework or Spring MVC

Версии можно смело брать самые последние. Конфликтов быть не должно.

Если копируете решение из интернета, то постарайтесь хотя бы сами разобраться что и как работает – очень поможет в дальнейшем в реальном проекте.

Приложение должно быть в виде проекта, который собирается с помощью maven. Обязательно должен присутствовать скрипт для создания и наполнения тестовыми данными вашей базы данных. Если для старта приложения после успешного деплоя нужны какие-то дополнительные махинации или танцы с бубном – просьба все это описать в каком-нибудь readme в корне проекта.

Визуальную часть проектов не рисую, т.к. хочу увидеть, как каждый сам реализует и посчитает нормальной свою реализацию задачи.

Огромная просьба: тестируйте свое приложение. Бывало много случаев, когда присылали полностью нерабочее приложение, или с огромным количеством багов.

1. CRUD (create, read, update, delete).

У вас есть всего 1 табличка User

isAdmin – в приложении это Boolean переменная.

Необходимо реализовать стандартное crud приложение, которое отображаем список всех юзеров в базе (с пейджингом). С возможностью их удаления, редактирования, добавления новых. И поиска по уже существующим.

По какому полю искать – каждый решает для себя сам. Можно ограничиться полем name, можно реализовать фильтр для любого поля.

2. TODO list

Реализовать простенькое приложение todolist, для отображения списка дел.

Нужно показывать список уже созданных дел. Каждое из них можно редактировать, добавлять новые, отмечать как «Выполнено», удалять. Список можно фильтровать как

«Все дела», «Только невыполненные», «Выполненные».

Дела хранить в базе. Схему таблички для хранения нужно придумать самому (можно ограничиться одной таблицей, можно разбить на несколько)


