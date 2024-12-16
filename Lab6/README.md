### 1. Що таке immutable об’єкт? Чому об’єкти класу `String` імутабельні? Чому клас `String` є final?

**Immutable об’єкт** — це об’єкт, стан якого не можна змінити після створення. У випадку `String` будь-яка операція, яка змінює його вміст, створює новий об’єкт, а не модифікує існуючий.

**Чому об’єкти `String` імутабельні**:
- **Безпека**: Гарантує, що строки не зміняться під час передачі, наприклад, у мережевих запитах чи при роботі з базами даних.
- **Ефективність**: Завдяки пулу строк (String pool) Java уникає створення дублікатів однакових строк.
- **Потокобезпека**: Імутабельність виключає необхідність синхронізації при роботі з багатопотоковими додатками.

**Чому `String` є final**:
- Клас `String` задекларований як `final`, щоб заборонити його наслідування. Це гарантує імутабельність, оскільки методи не можуть бути перевизначені для зміни поведінки.

---

### 2. Що таке регулярні вирази? Приклади.

**Регулярні вирази** — це шаблони, які дозволяють знаходити, перевіряти чи змінювати текстові рядки за заданим правилом.

**Приклади**:
- `\\d+` — знаходить одну чи більше цифр.
- `[a-zA-Z]+` — знаходить слова, що складаються лише з літер.
- `^\\s+|\\s+$` — виділяє пробіли на початку чи в кінці рядка.
- `\\b\\w{5}\\b` — слова довжиною рівно 5 символів.
- `[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}` — знаходить електронні адреси.

---

### 3. Різниця між `==` та `equals()`.

- **Оператор `==`**:
  - Порівнює посилання на об’єкти.
  - Повертає `true`, якщо обидва об’єкти вказують на ту ж область пам’яті.
- **Метод `equals()`**:
  - Порівнює вміст об’єктів.
  - Використовується для перевірки еквівалентності значень.

Приклад:
```java
String str1 = new String("hello");
String str2 = new String("hello");

System.out.println(str1 == str2); // false (різні об’єкти)
System.out.println(str1.equals(str2)); // true (однаковий вміст)
```

---

### 4. Призначення класів `StringBuilder` та `StringBuffer`.

- **`StringBuilder`**:
  - Використовується для роботи зі змінюваними строками в однопотоковому середовищі.
  - Швидший, оскільки не є синхронізованим.

- **`StringBuffer`**:
  - Використовується у багатопотоковому середовищі.
  - Синхронізований, що гарантує безпеку в багатопоточних програмах.

Обоє класів дозволяють додавати, змінювати чи видаляти текст без створення нових об'єктів.

---

### 5. Як прибрати пробіли на початку та в кінці строки?

Метод `trim()` класу `String` видаляє пробіли з початку та кінця:
```java
String str = "  Hello World  ";
String result = str.trim(); // "Hello World"
```

Для складніших випадків можна використовувати регулярні вирази:
```java
String result = str.replaceAll("^\\s+|\\s+$", "");
```