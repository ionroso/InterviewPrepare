package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    public static void main(String[] args) {
        String ops = new String("[\"SmallestInfiniteSet\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"popSmallest\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"addBack\",\"popSmallest\",\"addBack\",\"addBack\",\"addBack\"]");
        String opsVal = new String("[[],[84],[550],[88],[],[],[152],[],[413],[],[],[359],[33],[],[321],[],[],[],[],[],[],[],[],[827],[839],[618],[165],[],[89],[783],[708],[],[],[],[],[],[],[816],[],[],[],[],[],[],[869],[34],[707],[841],[957],[485],[527],[109],[254],[799],[442],[],[],[],[318],[],[],[980],[],[202],[],[],[993],[119],[],[],[188],[],[],[],[855],[],[],[],[],[],[630],[],[],[],[],[435],[67],[681],[396],[73],[],[218],[179],[868],[157],[435],[334],[],[514],[883],[641],[325],[60],[926],[67],[667],[709],[134],[763],[534],[],[899],[],[389],[],[24],[],[769],[473],[51],[],[],[479],[],[471],[991],[787],[288],[],[599],[455],[],[],[],[],[785],[991],[],[],[],[],[663],[],[990],[484],[246],[],[],[356],[],[618],[],[90],[],[],[27],[466],[],[493],[],[579],[170],[],[42],[],[],[],[645],[710],[],[],[458],[464],[],[],[418],[],[753],[],[441],[],[],[820],[395],[],[731],[19],[],[],[],[],[],[],[],[],[941],[917],[],[865],[537],[],[],[52],[],[604],[],[963],[862],[],[162],[],[],[89],[],[],[],[],[],[],[115],[691],[],[807],[],[],[],[529],[846],[529],[255],[],[799],[395],[759],[],[717],[],[728],[483],[],[],[],[],[],[],[],[],[140],[462],[537],[287],[],[],[],[180],[],[],[],[305],[856],[636],[561],[178],[],[660],[],[],[703],[578],[],[902],[99],[],[477],[259],[768],[],[726],[],[],[],[],[68],[463],[],[984],[],[511],[],[],[],[401],[106],[91],[],[671],[],[233],[],[],[94],[],[],[777],[451],[],[],[],[868],[],[],[133],[],[249],[128],[],[],[942],[991],[406],[886],[],[55],[470],[247],[],[],[943],[68],[],[],[],[],[],[],[],[],[108],[488],[685],[315],[832],[952],[],[],[208],[],[],[],[460],[],[],[],[189],[437],[],[642],[],[316],[],[],[356],[],[138],[628],[520],[],[],[771],[42],[549],[751],[17],[],[],[],[],[],[],[13],[],[],[],[270],[],[210],[],[764],[27],[419],[],[],[],[957],[],[996],[546],[32],[],[],[],[],[],[10],[412],[],[],[690],[220],[],[],[873],[],[219],[296],[647],[936],[],[],[56],[946],[897],[],[579],[],[],[],[],[333],[],[],[],[],[92],[212],[],[80],[],[289],[],[494],[907],[],[],[512],[],[],[],[],[552],[745],[874],[633],[],[],[],[],[],[656],[],[989],[479],[797],[807],[],[],[509],[280],[591],[],[3],[],[],[16],[],[796],[726],[],[],[125],[],[],[],[217],[908],[58],[],[],[432],[692],[],[23],[512],[],[554],[],[249],[953],[662],[143],[808],[627],[],[],[255],[],[952],[],[],[],[],[467],[],[],[852],[41],[302],[730],[644],[],[],[],[383],[],[510],[540],[194],[],[558],[],[],[676],[662],[],[940],[],[],[],[312],[],[],[93],[],[434],[],[],[],[],[150],[],[338],[575],[731],[710],[610],[],[],[],[],[],[],[],[938],[563],[],[],[],[734],[],[],[245],[],[],[],[],[],[173],[],[],[],[],[439],[],[],[],[451],[],[],[],[],[924],[],[],[],[],[],[33],[498],[],[80],[296],[],[391],[],[39],[522],[487],[119],[940],[999],[337],[],[],[406],[696],[],[493],[642],[],[841],[],[],[369],[],[],[],[],[],[396],[],[],[20],[328],[],[],[158],[751],[686],[],[233],[],[],[],[595],[984],[],[676],[101],[75],[397],[],[],[128],[],[242],[],[76],[526],[956],[377],[477],[957],[335],[],[],[],[],[622],[815],[381],[490],[],[908],[231],[],[],[504],[767],[419],[],[],[],[],[],[],[],[],[],[23],[],[408],[],[],[760],[730],[],[319],[],[605],[],[],[939],[638],[],[],[250],[],[513],[903],[],[],[251],[],[],[],[],[],[],[649],[5],[152],[],[],[716],[873],[120],[153],[],[],[],[312],[747],[533],[168],[289],[44],[168],[],[778],[],[971],[883],[],[],[901],[886],[931],[529],[71],[186],[],[805],[919],[670]]");

        String[] opsSplit = ops.substring(1, ops.length()-1).split(",");
        String[] opsValSplit = opsVal.substring(1, opsVal.length()-1).split(",");


        SmallestNumberInInfiniteSet.SmallestInfiniteSet sis = new SmallestNumberInInfiniteSet.SmallestInfiniteSet();
        for (int i = 1; i < opsSplit.length; i++) {
            String op =  opsSplit[i].substring(1,opsSplit[i].length()-1);
            String val = opsValSplit[i].substring(1,opsValSplit[i].length()-1);

            switch (op)
            {
                case "addBack" :{
                    System.out.println("addBack" + " " + val);
                    sis.addBack(Integer.valueOf(val));
//                    printQueue(sis.queue);
                    break;
                }
                case "popSmallest" :{
                    System.out.println("popSmallest" + " " + sis.popSmallest());
//                    printQueue(sis.queue);
                }
            }
        }
    }

    private static void printQueue(PriorityQueue<Integer> queue) {
        System.out.print("Current Q values:" );
        for (Integer val : queue) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


    static class SmallestInfiniteSet {
        public PriorityQueue<Integer> queue;
        public Integer last;

        public SmallestInfiniteSet() {
            queue = new PriorityQueue<>();
            last = 1;
        }

        public int popSmallest() {
            return !queue.isEmpty() ? queue.poll(): last++;
        }

        public void addBack(int num) {
            if(num<last && !queue.contains(num)){
                queue.offer(num);
            }
        }
    }
}