class ListElement {
    ListElement next;    // указатель на следующий элемент
    int data;
    int id;// данные
}


class List {
    private ListElement head;
    private ListElement tail;
    int id=0;
    void addFront(int data)
    {
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;              //инициализируем данные.
        // указатель на следующий элемент автоматически инициализируется как null
        if(head == null)            //если список пуст
        {
            head = a;
            tail = a;
            head.id=id;
            id++;
        }
        else {
            a.next = head;          //иначе новый элемент теперь ссылается на "бывший" первый
            head = a;
            head.id=id;
            id++;//а указатель на первый элемент теперь ссылается на новый элемент
        }
    }

    void addBack(int data) {          //добавление в конец списка
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;
        if (tail == null)           //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
            head.id=id;
        } else {
            tail.next = a;          //иначе "старый" последний элемент теперь ссылается на новый
            tail = a;
            tail.id=id;//а в указатель на последний элемент записываем адрес нового элемента
        }
    }

    void printList()                //печать списка
    {
        ListElement t = head;       //получаем ссылку на первый элемент
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
    }
    int searhElbyID(int id) {
        if (head == null)
            System.out.println("Список пуст");
            return -1;

        if (head == tail) {
            return head.data;
        }

        if (head.id == id) {
            return head.data;
        }

        ListElement t = head;
        while (t.next != null) {
            if (t.next.id ==id) {
                return t.next.data;
            }
            t = t.next;
        }
        System.out.println("Ошибка");
        return -1;
    }

    int searhElMAX()
    {
        int max=-100000000;
        if(head == null)
            return -1;

        if (head == tail) {

           max= tail.data;
        }

        if (head.data>= max) {
            max=head.data;
        }

        ListElement t = head;
        while (t.next != null) {
            if (t.next.data >=max) {
                max=t.next.data;
            }
            t = t.next;
        }

        return max;
    }
    int searhElMIN()
    {
        int min=100000000;
        if(head == null)
            return -1;

        if (head == tail) {

            min= tail.data;
        }

        if (head.data<= min) {
            min=head.data;
        }

        ListElement t = head;
        while (t.next != null) {
            if (t.next.data <=min) {
                min=t.next.data;
            }
            t = t.next;
        }

        return min;
    }
    int searhElaver()
    {
        int sum=0;
        if(head == null)
            return -1;

        if (head == tail) {

            min= tail.data;
        }

        if (head.data<= min) {
            min=head.data;
        }

        ListElement t = head;
        while (t.next != null) {
            if (t.next.data <=min) {
                min=t.next.data;
            }
            t = t.next;
        }

        return min;
    }

    int searhEl(int data)
    {
        if(head == null)
            return -1;

        if (head == tail) {

            return tail.id;
        }

        if (head.data == data) {
            return head.id;
        }

        ListElement t = head;
        while (t.next != null) {
            if (t.next.data == data) {
                return t.next.id;
            }
            t = t.next;
        }
        return -1;
    }

    void delEl(int data)          //удаление элемента
    {
        if(head == null)        //если список пуст -
            return;             //ничего не делаем

        if (head == tail) {     //если список состоит из одного элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }

        if (head.data == data) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }

        ListElement t = head;       //иначе начинаем искать
        while (t.next != null) {    //пока следующий элемент существует
            if (t.next.data == data) {  //проверяем следующий элемент
                if(tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next;   //найденный элемент выкидываем
                return;                 //и выходим
            }
            t = t.next;                //иначе ищем дальше
        }
    }
}
