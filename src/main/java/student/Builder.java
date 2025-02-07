package student;

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }


    /**
     * Builds an employee object from a CSV string.
     * <p>
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     *
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] s = csv.split(",");
        if(s.length != 7) {
            throw new IllegalArgumentException("Invalid CSV format.");
        }
        if (s[0].equals("HOURLY")) {
            return new HourlyEmployee(s[1], s[2], Double.parseDouble(s[3]), Double.parseDouble(s[5]), Double.parseDouble(s[6]), Double.parseDouble(s[4]));
        } else {
            return new SalaryEmployee(s[1], s[2], Double.parseDouble(s[3]), Double.parseDouble(s[5]), Double.parseDouble(s[6]), Double.parseDouble(s[4]));
        }

    }



        /**
         * Converts a TimeCard from a CSV String.
         *
         * @param csv csv string
         * @return a TimeCard object
         */
    public static ITimeCard buildTimeCardFromCSV (String csv){
        String[] s = csv.split(",");
        return new ITimeCard() {

            @Override
            public String getEmployeeID(){
                return s[0];
            }

            @Override
            public double getHoursWorked(){
                return Double.parseDouble(s[1]);
            }
        };

    }


}
