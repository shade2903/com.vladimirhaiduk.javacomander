# Javacommander
## Information
*Проект простого файлового менеджера.Реализованы простые функции: просмотр информации о файлах(имя,дата создания,расширение,тип, размер), копирование одиночных файлов и папок, перемещение и удаление*

##Руководство пользователя

Для работы с файлами необходимо, что бы поле файла с которым работают было подсвечено серым цветом. Поле в которое нужно переместить файл или копировать должно быть подсвечено синим.


##Принцип работы
В проекте реализованы 4 класса и 2 сцены:
-*Main*
-*FileInfo*
-*PanelController*
-*Controller*
-*main.fxml*
-*panel.fxml*

###++Main++
Класс отвечающий за запуск главной сцены. Содержит заголовки и настройки размеров основного окна.

###++FileInfo++
Класс содержит поля для работы с файлами:
-*имя*
-*тип*
-*размер*
-*дата*

###++PanelController++
Класс реализующий отображение информации о файлах, просмотр файлов и папок по пути следования.

###++Controller++
Класс реализующий работу с файлами и папками.
Копирует, перемещает, удаляет и создает новую директорию.

###++panel.fxml&main.fxml++
Сцена отвечающая за управление кнопками.

