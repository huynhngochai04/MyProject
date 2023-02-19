package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class City implements Serializable {
    private int cityCode;
    private String cityName;

    public static City getCityByName(String cityName) {
        ArrayList<City> listCity = City.getListCity();
        for (City searching : listCity){
            if (searching.getCityName().equals(cityName))
            {
                return searching;
            }
        }
        return null;
    }

    public void setCityCode(int index){
        this.cityCode = index;
    }
    public void setCityName(String index){
        this.cityName = index;
    }
    public int getCityCode(){
        return this.cityCode;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "City = [cityCode= "+cityCode+", cityName=" +cityName+"]";
    }
    public static ArrayList<City> getListCity(){
        String [] arrayCity = {
                "An Giang",
                "Bà Rịa – Vũng Tàu",
                "Bạc Liêu",
                "Bắc Giang",
                "Bắc Kạn",
                "Bắc Ninh",
                "Bến Tre",
                "Bình Dương",
                "Bình Định",
                "Bình Phước",
                "Bình Thuận",
                "Cà Mau",
                "Cao Bằng",
                "Cần Thơ",
                "Đà Nẵng",
                "Đắk Lắk",
                "Đắk Nông",
                "Điện Biên",
                "Đồng Nai",
                "Đồng Tháp",
                "Gia Lai",
                "Hà Giang",
                "Hà Nam",
                "Hà Nội",
                "Hà Tĩnh",
                "Hải Dương",
                "Hải Phòng",
                "Hậu Giang",
                "Hòa Bình",
                "Thành phố Hồ Chí Minh",
                "Hưng Yên",
                "Khánh Hòa",
                "Kiên Giang",
                "Kon Tum",
                "Lai Châu",
                "Lạng Sơn",
                "Lào Cai",
                "Lâm Đồng",
                "Long An",
                "Nam Định",
                "Nghệ An",
                "Ninh Bình",
                "Ninh Thuận",
                "Phú Thọ",
                "Phú Yên",
                "Quảng Bình",
                "Quảng Nam",
                "Quảng Ngãi",
                "Quảng Ninh",
                "Quảng Trị",
                "Sóc Trăng",
                "Sơn La",
                "Tây Ninh",
                "Thái Bình",
                "Thái Nguyên",
                "Thanh Hóa",
                "Thừa Thiên Huế",
                "Tiền Giang",
                "Trà Vinh",
                "Tuyên Quang",
                "Vĩnh Long",
                "Vĩnh Phúc",
                "Yên Bái"
        };
        int i=1;
        ArrayList<City> listCityUpdate = new ArrayList<City>();
        for (String cityname : arrayCity){
            City city = new City(i,cityname);
            listCityUpdate.add(city);
            i++;
        }
        return listCityUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return getCityCode() == city.getCityCode() && Objects.equals(getCityName(), city.getCityName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityCode(), getCityName());
    }

    public static City getCityNameById(String index){
        City city = new City();
        ArrayList<City> listCity = City.getListCity();
        int count = 1;
        for (City search : listCity){
            if (search.cityCode==Integer.parseInt(index)){
                city = search;
            }
        }
        return city;
    }
    public City() {
    }

    public City(int cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public String getCityName(){
        return this.cityName;
    }
}
