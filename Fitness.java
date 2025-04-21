/*
* Fitness.java
* @author JiaLiu
* 8/11/24
*/

public class Fitness {
    // Declare variables
    private double temperature;
    private double humidity;
    private double windSpeed;
    private int uvIndex;
    private double weight;
    private double met;
    private double duration;

    // Constructor
    public Fitness(double temperature, double humidity, double windSpeed, int uvIndex, double weight, double met, double duration) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.uvIndex = uvIndex;
        this.weight = weight;
        this.met = met;
        this.duration = duration;
    }

    // Getter and Setter
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }

    public double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }

    public int getUvIndex() { return uvIndex; }
    public void setUvIndex(int uvIndex) { this.uvIndex = uvIndex; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getMet() { return met; }
    public void setMet(double met) { this.met = met; }

    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }

    // compute

    // Method: Recommend activity based on temperature
    public String recommendActivityByTemperature() {
        if (temperature < 0) {
            return "Recommend indoor activities like yoga or strength training";
        } else if (temperature <= 10) {
            return "Recommend outdoor activities like jogging or hiking, and advise dressing warmly";
        } else if (temperature <= 25) {
            return "Recommend outdoor activities like running, cycling, or tennis";
        } else {
            return "Recommend swimming or water sports, and suggest doing outdoor activities in the early morning or evening to avoid the heat";
        }
    }

    // Method: Calculate heat index and provide recommendations based on it
    public String calculateHeatIndex() {
        if (temperature >= 20 && humidity <= 50) {
            double heatIndex = temperature + (0.33 * humidity) - (0.7 * windSpeed)- 4.00;
            if (heatIndex > 30) {
                return "The heat index is " + heatIndex + ". Avoid strenuous outdoor activities, and consider alternatives like walking or swimming.";
            } else {
                return "The heat index is " + heatIndex + ". You may proceed with normal activities.";
            }
        } else {
            return "There is no specific guidance based on that temperature.";
        }
    }

    // Method: Recommend activity based on wind speed
    public String recommendActivityByWindSpeed() {
        if (windSpeed > 40) {
            return "Advise avoiding activities like cycling or running";
        } else if (windSpeed >= 20) {
            return "Recommend activities like jogging or hiking in sheltered areas";
        } else {
            return "All outdoor activities are safe to perform";
        }
    }

    // Method: Recommend UV protection precautions
    public String recommendUvPrecautions() {
        if (uvIndex > 7) {
            return "Advise applying sunscreen, avoiding direct sunlight during peak hours (10 AM - 4 PM), and wearing protective clothing, a hat, and sunglasses";
        } else if (uvIndex >= 5) {
            return "Advise using sunscreen and wearing a hat";
        } else {
            return "No specific sun protection is required, though sunscreen is still encouraged";
        }
    }

    // Method: Calculate calories burned based on MET, weight, and duration
    public double calculateCaloriesBurned() {
        return met * weight * duration;
    } // mian
}// class