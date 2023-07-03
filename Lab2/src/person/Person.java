package person;

import annotation.MyAnnotation;

public class Person {
        @MyAnnotation(value = 1)
        public void getName(String name){
            System.out.println("public void getName, argument value:" + name);
        }
        @MyAnnotation(value = 2)
        public void getWeight(String weight){
            System.out.println("public void getWeight, argument value: " + weight);
        }
        @MyAnnotation(value = 3)
        private void getAddress(String address){
            System.out.println("private void getAddress, argument value: " + address);
        }

        @MyAnnotation(value = 4)
        private void getAge(String age){
            System.out.println("private void getAge, argument value: " + age);
        }

        @MyAnnotation(value = 5)
        protected void getPhone(String phone){
            System.out.println("protected void getPhone, argument value: " + phone);
        }

        @MyAnnotation(value = 6)
        protected void getSurname(String surname){
            System.out.println("protected void getSurname, argument value: " + surname);
        }


}
