package tools.maker;
import system.CoffeeRequst.Req;
import goods.homemade.coffee.Coffee;

/**
 * 咖啡机类，用于获取指定类型的咖啡实体
 * @author 刘畅
 * @version 0.1
 */
public  class CoffeeMaker extends DesertMaker {
    CoffeeBuilder coffeeBuilder;
    Coffee empty;
    boolean busy;

	public CoffeeMaker() {
		super();
		busy=false;
	}

	@Override
	public void work(Object req, Object returnObj) {
         busy=true;
         Req req1 = (Req)req;
         Coffee coffee = getCoffee(req1.type, req1.temperature,req1.sweetness,req1.price);
         ((Coffee) returnObj).setName(coffee.getName());
         ((Coffee) returnObj).setTemperature(coffee.getTemperature());
         ((Coffee) returnObj).setSweetness(coffee.getSweetness());
		 ((Coffee) returnObj).setPrice(coffee.getPrice());
         busy=false;
	}

	@Override
	public boolean isBusy(){
		return busy;
	}
	/**
	 *通过调用此接口获取一个制定的咖啡实体
	 * @param type  0.AmericanCoffee 1.GappuccinoCoffee 2.MochaCoffee
	 * @param temperature 0.Cool 1.Normal 2.Hot
	 * @param sweetness 0.FreeSugar 1.HalfSugar 2.RegularSugar
	 * @param price
	 * @return
	 */
	Coffee getCoffee(int type,int temperature,int sweetness,double price){
		empty=new Coffee();
		empty.setName("Empty");
		if((type!=0)&&(type!=1)&&(type!=2))return empty;
		if((temperature!=0)&&(temperature!=1)&&(temperature!=2))return empty;
		if((sweetness!=0)&&(sweetness!=1)&&(sweetness!=2))return empty;
		if(type==0)coffeeBuilder=new AmericanCoffeeBuilder();
		else if(type==1)coffeeBuilder=new GappuccinoCoffeeBuilder();
		else if(type==2)coffeeBuilder=new MochaCoffeeBuilder();

		coffeeBuilder.makeCoffee();
		coffeeBuilder.setSweetness(sweetness);
		coffeeBuilder.setTemperature(temperature);
		coffeeBuilder.setPrice(price);
		coffeeBuilder.setName();
		return coffeeBuilder.getCoffee();
	}

}
