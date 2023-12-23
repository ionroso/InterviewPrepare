package utility;

import java.util.Iterator;

public class LeetcodeInputIterator  implements Iterator<String> {
    String[] input;
    int index=0;

    public LeetcodeInputIterator(IParser parser, String input) {
        this.input = parser.parse(input);
    }

    @Override
    public boolean hasNext() {
        return index < input.length;
    }

    @Override
    public String next() {
        if(!hasNext()) return null;
        return input[index++];
    }

    public static void main(String[] args) {
        LeetcodeInputIterator method = new LeetcodeInputIterator(new LeetcodeMethodsCallStackInputParser(","),"[\"ATM\",\"deposit\",\"deposit\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"withdraw\",\"deposit\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"deposit\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"withdraw\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"deposit\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"withdraw\",\"withdraw\",\"withdraw\",\"deposit\",\"withdraw\",\"deposit\",\"deposit\",\"deposit\"]");
        LeetcodeInputIterator input = new LeetcodeInputIterator(new LeetcodeArgsParser(),"[[],[[250796,638723,691758,845522,938973]],[[215317,848628,182949,784609,30472]],[701035245],[109992310],[755819795],[722349970],[[678816,841145,503892,325349,204606]],[[604328,586349,680353,733891,136713]],[[500950,53467,775875,469508,668335]],[[178876,500427,867418,738121,80412]],[824714410],[374969115],[351532175],[732076765],[[208564,707512,566329,300547,313109]],[774911195],[[742897,902293,512670,863273,105945]],[449705540],[[94829,872976,822744,630565,726268]],[981495000],[426983925],[591589125],[90436530],[300789750],[544232655],[[333998,671859,821084,678512,239841]],[816423815],[393272210],[[146335,604905,570672,384321,645355]],[184328925],[189043175],[[403571,361640,202265,108809,340899]],[630857120],[521903750],[[309733,543710,227714,682033,689707]],[409081030],[[140651,880799,664632,684067,189015]],[[653204,683646,273200,738271,768502]],[760807085],[[585693,749948,134852,936077,496241]],[598212970],[609144120],[173711145],[871970745],[[905672,917631,538045,213759,467121]],[[84394,842857,110657,83685,396409]],[283842105],[[547660,711399,37793,248979,171209]],[[721908,683510,507961,315580,915329]],[[724268,208639,86180,559536,369337]],[[18276,789197,268868,573790,51430]],[666573505],[402867945],[141646455],[989327245],[63547525],[793492260],[469750915],[[514958,777169,647876,692862,13212]],[134587615],[[698672,953618,770724,795084,787545]],[[381744,405569,839476,243652,173030]],[[371633,758052,510149,114478,847007]],[210704305],[[519428,519225,244531,859848,501054]],[[447308,71049,586248,739061,22236]],[[480462,388981,61696,465612,585484]],[[337913,996104,569476,144324,941825]],[875707660],[57569050],[313791115],[[495361,267828,569079,266649,318023]],[910215005],[[11564,454722,326554,617698,951649]],[737599780],[[459779,367480,721883,267540,616449]],[416183255],[[919244,501903,797594,255088,277900]],[[544488,760,373644,587808,462016]],[542186870],[[141787,245536,713162,249389,360758]],[[448335,140890,944469,820805,953212]],[[83472,483020,89382,734004,496270]],[[355454,592701,579669,600758,935825]],[[509278,123040,366474,967560,94569]],[[814617,106257,843008,148633,281962]],[92776780],[710233240],[[540287,779680,232597,843398,982588]],[943887435],[83641580],[[641807,238897,514709,878576,185671]],[[788165,163263,468077,187322,741170]],[[403619,495280,682590,976711,662733]],[[790416,971353,997540,833823,438455]],[[519889,768434,1186,576547,159969]],[[87541,987828,423814,667020,113391]],[739876825],[380847695],[[127434,690184,220342,251031,510668]],[736450270],[660460695],[[674760,193528,502970,437004,476214]],[[624107,419876,767550,454735,284487]],[[362461,226745,880847,364186,203497]],[102135095],[[187479,420361,4452,558218,944230]],[121284120],[[109227,412189,999147,755248,350021]],[[698704,927765,231972,325370,183792]],[380738930],[496198165],[119768090],[[907559,446837,965002,40373,684480]],[26609515],[[482552,665813,947214,295057,531240]],[[996330,771481,324291,338518,643748]],[[765310,513263,973288,667581,27556]]]");
        LeetcodeInputIterator output = new LeetcodeInputIterator( new LeetcodeOutputParser(),"[null,null,null,[-1],[-1],[-1],[1,1,0,1188137,969445],null,null,null,null,[-1],[-1],[-1],[-1],null,[-1],null,[2,0,0,0,899411],null,[0,0,0,0,1962990],[-1],[-1],[-1],[0,1,0,1,601579],[-1],null,[-1],[-1],null,[-1],[-1],null,[1,0,1,0,1261714],[0,1,0,1,1043807],null,[-1],null,null,[-1],null,[1,1,0,2,1196425],[1,0,1,0,1218288],[-1],[-1],null,null,[-1],null,null,null,null,[-1],[-1],[-1],[-1],[-1],[-1],[-1],null,[-1],null,null,null,[-1],null,null,null,null,[-1],[0,1,0,0,115138],[-1],null,[-1],null,[-1],null,[-1],null,null,[1,1,1,1,1084373],null,null,null,null,null,null,[-1],[2,0,0,1,1420466],null,[-1],[-1],null,null,null,null,null,null,[-1],[-1],null,[1,1,0,1,1472900],[-1],null,null,null,[-1],null,[1,0,1,0,242568],null,null,[-1],[-1],[2,1,0,0,239536],null,[-1],null,null,null]");
        LeetcodeInputIterator expected = new LeetcodeInputIterator(new LeetcodeOutputParser(),"[null,null,null,[-1],[-1],[-1],[1,1,0,1188137,969445],null,null,null,null,[-1],[-1],[-1],[-1],null,[-1],null,[2,0,0,0,899411],null,[0,0,1,1567532,1335977],[-1],[-1],[-1],[0,1,1,1503948,0],[-1],null,[-1],[-1],null,[-1],[-1],null,[1,0,0,89048,1226095],[0,1,190313,2514362,0],null,[-1],null,null,[-1],null,[1,1,0,2,1196425],[1,0,1,678120,947040],[-1],[-1],null,null,[-1],null,null,null,null,[-1],[-1],[-1],[-1],[-1],[-1],[-1],null,[-1],null,null,null,[-1],null,null,null,null,[-1],[0,1,0,0,115138],[-1],null,[-1],null,[-1],null,[-1],null,null,[1,1,1,1,1084373],null,null,null,null,null,null,[-1],[2,0,0,1,1420466],null,[-1],[-1],null,null,null,null,null,null,[-1],[-1],null,[1,1,0,1,1472900],[-1],null,null,null,[-1],null,[1,0,1,0,242568],null,null,[-1],[-1],[2,1,0,0,239536],null,[-1],null,null,null]");

        Iterator<String> methodIterator = method;
        Iterator<String> inputIterator = input;
        Iterator<String> outputIterator = output;
        Iterator<String> expectedIterator = expected;
        int i = 0;
        while (methodIterator.hasNext()){
            String outputStr = outputIterator.next();
            String expectedStr = expectedIterator.next();
            System.out.println(i + " " + methodIterator.next() + " " + inputIterator.next());
            System.out.println(i + " " + outputStr + " " + expectedStr + " " + outputStr.equals(expectedStr));
            i++;
        }
    }
}
