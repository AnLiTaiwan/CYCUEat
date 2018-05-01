package defaultDATA;

import java.util.Vector;

public class DefaultDATA {

  private final String[] PRODUCE = { "20,茉莉綠茶,飲料,中原達人鮮果茶鋪", "20,錫蘭紅茶,飲料,中原達人鮮果茶鋪",
                                     "20,冬瓜茶,飲料,中原達人鮮果茶鋪", "30,蜜茶,飲料,中原達人鮮果茶鋪",
                                     "25,薄荷紅/綠茶,飲料,中原達人鮮果茶鋪", "25,梅子紅/綠茶,飲料,中原達人鮮果茶鋪", 
                                     "25,峰蜜紅/綠茶,飲料,中原達人鮮果茶鋪", "25,椰果紅/綠茶,飲料,中原達人鮮果茶鋪", 
                                     "25,珍珠紅/綠茶,飲料,中原達人鮮果茶鋪", "25,冬瓜椰果茶,飲料,中原達人鮮果茶鋪", 
                                     "25,冬瓜仙草茶,飲料,中原達人鮮果茶鋪", "25,冬瓜珍珠茶,飲料,中原達人鮮果茶鋪",
                                     "25,皇家奶茶,飲料,中原達人鮮果茶鋪", "30,珍珠奶茶,飲料,中原達人鮮果茶鋪", 
                                     "30,蜂蜜奶茶,飲料,中原達人鮮果茶鋪", "30,椰果奶茶,飲料,中原達人鮮果茶鋪", 
                                     "30,胚芽奶茶,飲料,中原達人鮮果茶鋪", "30,焦糖奶茶,飲料,中原達人鮮果茶鋪", 
                                     "30,薄荷奶茶,飲料,中原達人鮮果茶鋪", "30,芋香奶茶,飲料,中原達人鮮果茶鋪", 
                                     "30,仙草凍奶茶,飲料,中原達人鮮果茶鋪", "35,布丁奶茶,飲料,中原達人鮮果茶鋪", 
                                     "40,布丁珍奶,飲料,中原達人鮮果茶鋪", "40,冬瓜鮮奶,飲料,中原達人鮮果茶鋪", 
                                     "40,鮮奶茶(紅茶拿鐵),飲料,中原達人鮮果茶鋪", "35,芭樂汁,飲料,中原達人鮮果茶鋪", 
                                     "35,柳橙汁,飲料,中原達人鮮果茶鋪", "35,檸檬汁,飲料,中原達人鮮果茶鋪", 
                                     "40,蘋果汁,飲料,中原達人鮮果茶鋪", "40,芒果汁,飲料,中原達人鮮果茶鋪", 
                                     "40,葡萄柚汁,飲料,中原達人鮮果茶鋪", "40,紅蘿蔔汁,飲料,中原達人鮮果茶鋪", 
                                     "45,奇異果汁,飲料,中原達人鮮果茶鋪", "45,蘋果牛奶,飲料,中原達人鮮果茶鋪", 
                                     "45,木瓜牛奶,飲料,中原達人鮮果茶鋪", "45,香蕉牛奶,飲料,中原達人鮮果茶鋪", 
                                     "45,鳳梨牛奶,飲料,中原達人鮮果茶鋪", "45,芒果牛奶,飲料,中原達人鮮果茶鋪", 
                                     "30,柳橙綠/紅茶,飲料,中原達人鮮果茶鋪", "30,百香綠/紅茶,飲料,中原達人鮮果茶鋪", 
                                     "35,百香珍珠綠/紅茶,飲料,中原達人鮮果茶鋪", "35,百香椰果綠/紅茶,飲料,中原達人鮮果茶鋪", 
                                     "35,檸檬綠/紅茶,飲料,中原達人鮮果茶鋪", "35,葡萄柚綠/紅茶,飲料,中原達人鮮果茶鋪", 
                                     "40,檸檬愛玉,飲料,中原達人鮮果茶鋪", "40,百香愛玉綠茶,飲料,中原達人鮮果茶鋪", 
                                     "40,葡萄柚檸檬綠茶,飲料,中原達人鮮果茶鋪", "45,綜合水果茶,飲料,中原達人鮮果茶鋪", 
                                     "35,金桔檸檬汁,飲料,中原達人鮮果茶鋪", "40,鳳梨蘋果汁,飲料,中原達人鮮果茶鋪", 
                                     "40,柳橙蘋果汁,飲料,中原達人鮮果茶鋪", "40,柳橙鳳梨汁,飲料,中原達人鮮果茶鋪", 
                                     "40,柳橙百香果汁,飲料,中原達人鮮果茶鋪", "40,柳橙葡萄柚汁,飲料,中原達人鮮果茶鋪", 
                                     "40,芒果柳橙汁,飲料,中原達人鮮果茶鋪", "40,芒果鳳梨汁,飲料,中原達人鮮果茶鋪", 
                                     "40,芒果百香果汁,飲料,中原達人鮮果茶鋪", "45,鳳梨奇異果汁,飲料,中原達人鮮果茶鋪", 
                                     "45,蘋果奇異果汁,飲料,中原達人鮮果茶鋪", "45,綜合果汁,飲料,中原達人鮮果茶鋪", 
                                     "50,活力蔬果汁,飲料,中原達人鮮果茶鋪", "30,黑糖薑母茶,飲料,中原達人鮮果茶鋪",
                                     "35,巧克力奶茶,飲料,中原達人鮮果茶鋪", "35,阿華田,飲料,中原達人鮮果茶鋪", 
                                     "35,熱桔茶,飲料,中原達人鮮果茶鋪", "35,桂圓紅棗茶,飲料,中原達人鮮果茶鋪", 
                                     "40,蜂蜜柚子茶,飲料,中原達人鮮果茶鋪", "35,黑糖薑母奶茶,飲料,中原達人鮮果茶鋪", 
                                     "50,日式燒肉飯,飯,中原達人鮮果茶鋪", "50,田園蔬菜飯,飯,中原達人鮮果茶鋪", 
                                     "50,蘋果咖哩燴飯,飯,中原達人鮮果茶鋪", "50,沙茶鮮菇燴飯,飯,中原達人鮮果茶鋪", 
                                     "60,紅燒牛腩燴飯,飯,中原達人鮮果茶鋪", "35,海苔肉鬆粥,粥,中原達人鮮果茶鋪",
                                     "45,皮蛋瘦肉粥,粥,中原達人鮮果茶鋪", "55,香菇瘦肉粥,粥,中原達人鮮果茶鋪", 
                                     "55,吻魚瘦肉粥,粥,中原達人鮮果茶鋪", "45,蔬菜玉米粥,粥,中原達人鮮果茶鋪",
                                     "25,水果切盤(A),小點心,中原達人鮮果茶鋪", "35,水果切盤(B),小點心,中原達人鮮果茶鋪", 
                                     "45,水果切盤(C),小點心,中原達人鮮果茶鋪", "60,水果切盤(D),小點心,中原達人鮮果茶鋪", 
                                     "時價,五顏六色水果盤,小點心,中原達人鮮果茶鋪","50,日式鱈魚飯,飯,學餐B攤", 
                                     "50,鮭魚排飯,飯,學餐B攤", "50,泰式鮭魚排飯,飯,學餐B攤", 
                                     "50,蝦排飯,飯,學餐B攤", "50,泰式蝦排飯,飯,學餐B攤", 
                                     "60,滷雞腿飯,飯,學餐B攤", "60,泰式排骨飯,飯,學餐B攤", 
                                     "60,椒麻排骨飯,飯,學餐B攤", "60,鮑魚飯,飯,學餐B攤", 
                                     "60,油雞飯,飯,學餐B攤", "60,大板排骨飯,飯,學餐B攤", 
                                     "70,香雞排飯,飯,學餐B攤", "70,泰式香雞排飯,飯,學餐B攤", 
                                     "70,椒麻雞排飯,飯,學餐B攤", "70,炸雞腿飯,飯,學餐B攤", 
                                     "70,泰式炸雞腿飯,飯,學餐B攤", "70,椒麻雞腿飯,飯,學餐B攤", 
                                     "70,粉蒸排骨飯,飯,學餐B攤", "70,無錫排骨飯,飯,學餐B攤", 
                                     "70,京都排骨飯,飯,學餐B攤", "70,蔥爆豬肉飯,飯,學餐B攤", 
                                     "70,左宗棠雞飯,飯,學餐B攤", "70,牛肉拌飯,飯,學餐B攤", 
                                     "50,泰式鱈魚飯,飯,學餐B攤", "50,炒飯,飯,學餐B攤",
                                     "50,炒麵,麵,學餐B攤", "50,炒米粉,米粉,學餐B攤",
                                     "50,雞腿,小點心,學餐B攤", "50,雞排,小點心,學餐B攤",
                                     "30,牛肉湯,湯,學餐D攤", "25,玉米蛋花湯,湯,學餐D攤", 
                                     "25,酸辣湯,湯,學餐D攤", "35,水餃10個,水餃,學餐D攤",  
                                     "70,水餃20個,水餃,學餐D攤", "40,煎餃10個,水餃,學餐D攤", 
                                     "65,煎餃15個,水餃,學餐D攤", "80,煎餃 20個,水餃,學餐D攤",
                                     "15,水餃15個,水餃,學餐D攤", "50,酸辣湯餃10個,湯餃,學餐D攤",  
                                     "50,玉米湯餃10個,湯餃,學餐D攤", "65,酸辣湯餃15個,湯餃,學餐D攤", 
                                     "65,牛肉湯餃15個,湯餃,學餐D攤", "65,玉米湯餃15個,湯餃,學餐D攤", 
                                     "80,酸辣湯餃20個,湯餃,學餐D攤", "80,牛肉湯餃20個,湯餃,學餐D攤", 
                                     "80,玉米湯餃20個,湯餃,學餐D攤", "50,牛肉湯餃10個,湯餃,學餐D攤",
                                     "60,番茄嫩雞義大利麵,麵,學餐C攤", "60,番茄豬肉義大利麵,麵,學餐C攤", 
                                     "60,番茄鮪魚義大利麵,麵,學餐C攤", "60,番茄培根義大利麵,麵,學餐C攤", 
                                     "60,番茄德國香腸義大利麵,麵,學餐C攤", "60,奶油嫩雞義大利麵,麵,學餐C攤", 
                                     "60,奶油鮪魚義大利麵,麵,學餐C攤", "60,奶油培根義大利麵,麵,學餐C攤", 
                                     "60,奶油德國香腸義大利麵,麵,學餐C攤", "60,奶油豬肉義大利麵,麵,學餐C攤", 
                                     "60,青醬嫩雞義大利麵,麵,學餐C攤", "60,青醬豬肉義大利麵,麵,學餐C攤", 
                                     "60,青醬鮪魚義大利麵,麵,學餐C攤", "60,青醬培根義大利麵,麵,學餐C攤", 
                                     "60,青醬德國香腸義大利麵,麵,學餐C攤", "60,香辣嫩雞義大利麵,麵,學餐C攤", 
                                     "60,香辣鮪魚義大利麵,麵,學餐C攤", "60,香辣培根義大利麵,麵,學餐C攤", 
                                     "60,香辣德國香腸義大利麵,麵,學餐C攤", "60,香辣豬肉義大利麵,麵,學餐C攤", 
                                     "60,香辣嫩雞燉飯,飯,學餐C攤", "60,香辣豬肉燉飯,飯,學餐C攤", 
                                     "60,香辣鮪魚燉飯,飯,學餐C攤", "60,香辣培根燉飯,飯,學餐C攤", 
                                     "60,香辣德國香腸燉飯,飯,學餐C攤", "60,青醬嫩雞燉飯,飯,學餐C攤", 
                                     "60,青醬鮪魚燉飯,飯,學餐C攤", "60,青醬培根燉飯,飯,學餐C攤", 
                                     "60,青醬德國香腸燉飯,飯,學餐C攤", "60,青醬豬肉燉飯,飯,學餐C攤", 
                                     "60,奶油嫩雞燉飯,飯,學餐C攤", "60,奶油豬肉燉飯,飯,學餐C攤", 
                                     "60,奶油鮪魚燉飯,飯,學餐C攤", "60,奶油培根燉飯,飯,學餐C攤", 
                                     "60,奶油德國香腸燉飯,飯,學餐C攤", "60,番茄嫩雞燉飯,飯,學餐C攤", 
                                     "60,番茄鮪魚燉飯,飯,學餐C攤", "60,番茄培根燉飯,飯,學餐C攤", 
                                     "60,番茄德國香腸燉飯,飯,學餐C攤", "60,番茄豬肉燉飯,飯,學餐C攤", 
                                     "50,肉骨茶,湯,學餐E攤", "45,肉骨茶湯麵,麵,學餐E攤",
                                     "45,肉骨茶湯泡飯,飯,學餐E攤", "50,肉骨茶湯河粉,冬粉,學餐E攤",
                                     "50,肉骨茶湯米粉,冬粉,學餐E攤", "50,肉骨茶湯冬粉,冬粉,學餐E攤",
                                     "60,肉骨小牌麵,麵,學餐E攤", "60,肉骨小排河粉,冬粉,學餐E攤",
                                     "60,肉骨小牌泡飯,飯,學餐E攤", "10,貴妃蛋,小點心,學餐E攤", 
                                     "60,獅子頭蓋飯,飯,學餐E攤", "45,香辣老虎飯,飯,學餐E攤",
                                     "45,香辣老虎麵,麵,學餐E攤", "60,咖哩蓋飯,飯,學餐E攤",
                                     "60,咖哩蓋麵,麵,學餐E攤", "45,紅燒湯麵,麵,學餐E攤",
                                     "45,紅燒湯泡飯,飯,學餐E攤", "60,紅燒小牌麵,麵,學餐E攤",
                                     "60,紅燒小排河粉,冬粉,學餐E攤", "60,紅燒小牌泡飯,飯,學餐E攤",
                                     "70,紅燒小牌蓋飯,飯,學餐E攤", "60,鮪魚肉骨茶麵,麵,學餐E攤",
                                     "60,鮪魚肉骨茶河粉,冬粉,學餐E攤", "60,鮪魚肉骨茶泡飯,飯,學餐E攤",
                                     "65,鮪魚蓋飯,飯,學餐E攤", "35,肉燥乾麵,麵,學餐E攤",
                                     "35,肉燥飯,飯,學餐E攤", "40,肉燥河粉,冬粉,學餐E攤",
                                     "40,肉燥米粉,冬粉,學餐E攤", "40,肉燥冬粉,冬粉,學餐E攤" } ;
  public int getSize() {
    return this.PRODUCE.length ;
  } // getSize()
  
  public Vector< String > getItem( int i ) {
    Vector< String > rtn = new Vector< String >() ;
    String[] data = this.PRODUCE[ i ].split( "," ) ;
    rtn.add( i + "" ) ;
    rtn.add( data[0] ) ;
    rtn.add( data[1] ) ;
    rtn.add( data[2] ) ;
    rtn.add( data[3] ) ;
    rtn.add( "1" ) ;
    return rtn ;
  } // getItem()
  
} // class DefaultDATA
