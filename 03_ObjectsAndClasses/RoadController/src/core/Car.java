package core;

public class Car {

        public String number;//объявление переменной String
        public int height;//объявление переменной int
        public double weight;//объявление переменной double
        public boolean hasVehicle;//объявление переменной boolean
        public boolean isSpecial;//объявление переменной boolean

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public boolean isHasVehicle() {
            return hasVehicle;
        }

        public void setHasVehicle(boolean hasVehicle) {
            this.hasVehicle = hasVehicle;
        }

        public boolean isSpecial() {
            return isSpecial;
        }

        public void setSpecial(boolean special) {
            isSpecial = special;
        }

        public String toString()
        {
            String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";//объявление переменной String
            return "\n=========================================\n" +
                    special + "Автомобиль с номером " + number +
                    ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
        }
}