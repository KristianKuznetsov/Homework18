import java.util.*;

public class TaskBuilder {
    private static final int TASK_1_UPPER_BORDER = 10;
    private static final int TASK_1_ARRAY_SIZE = 10;
    private static final int TASK_STAR_SIZE = 15;

    private static final String[] NAMES = {
            "Alice", "Bob", "Charlie", "David", "Eve",
            "Frank", "Grace", "Harry", "Ivy", "Jack",
            "Kate", "Liam", "Mia", "Nora", "Oliver"
    };

    //Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью Stream:
    //- Удалить дубликаты
    //- Оставить только четные элементы
    //- Вывести сумму оставшихся элементов в стриме

    public static void build1() {
        ArrayList<Integer> arrayList = getRandomIntegerArrayList();
        System.out.println("Первоночальная колекция: " + arrayList);

        int sum = arrayList
                .stream()
                .distinct()
                .filter(el -> el % 2 == 0)
                .reduce(0, Integer::sum);

        System.out.println("Получаем: " + sum);
        System.out.println();
    }

    //Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
    //этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
    //Среди отобранных значений отобрать только те, которые имеют нечетное количество
    //букв в имени. После чего вернуть список List имен, записанных буквами задом наперед.

    public static void buildStar() {
        Map<Integer, String> map = getIdNameMap();
        System.out.println("Имеем выборку: " + map);

        List<String> result = map.entrySet()
                .stream()
                .filter((el) -> List.of(1, 2, 5, 8, 9, 13).contains(el.getKey()))
                .filter((el) -> el.getValue().length() % 2 == 1)
                .map((el) -> new StringBuilder(el.getValue()).reverse().toString())
                .toList();

        System.out.println("Получаем: " + result);
    }


    private static ArrayList<Integer> getRandomIntegerArrayList() {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TASK_1_ARRAY_SIZE; i++) {
            arrayList.add(random.nextInt(TASK_1_UPPER_BORDER));
        }
        return arrayList;
    }

    private static HashMap<Integer, String> getIdNameMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < TASK_STAR_SIZE; i++) {
            map.put(i, NAMES[random.nextInt(NAMES.length)]);
        }
        return map;
    }

}
