
/*
 * 2/26/25
 * Sw Design with Java
 * Jonathan Martinez
 * 
 */
public class ThirtyB {

    public abstract class Sensor {
        private String name;
        private int modelNumber;
        
        public String getName() {
            return name;
        }
        
        public void setName(String newName) {
            name = newName;
        }
        
        public int getModelNumber() {
            return modelNumber;
        }
        
        public void setModelNumber(int newModelNumber) {
            modelNumber = newModelNumber;
        }
        
        public abstract void recordMeasurement();
    }
}
