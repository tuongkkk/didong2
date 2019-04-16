package myapplication.tdc.edu.vn.soundpool;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView textMaxTime;
    private TextView textCurrentPosition;
    private TextView textMusic;
    private TextView textSingle;
    private TextView textLyric;
    private Button buttonPause;
    private Button buttonStart;
    private SeekBar seekBar;
    private Handler threadHandler = new Handler();

    private MediaPlayer mediaPlayer;
    private int songId;
    private int number = 1;

    private String music_Id[]= new String[]{"overlap","kho","hero","phtn","meohoang"};
    private String music_Name[]= new String[]{"Overlap","Khó","Giấc mộng thời trai","Phong, Hoa, Tuyết, Nguyệt","Mèo hoang"};
    private String music_Single[]= new String[]{"Kimeru","Nam Cường","Luo Wu E Mu","Tử Đường Túc, Lâm Tà Dương","Vũ Duy"};
    private String music_Lyrics[]= new String[]{
            "Ánh sáng rực rỡ đó không thể che khuất đi.\n"+
            "những máng tối tĩnh mịch và làm hồi sinh thế giới này.\n"+
            "Rung động mãnh liệt và trái đất như đang thèm khát.\n"+
            "Chỉ cần một giây phút ngắn ngủi...\n"+
            "Tạo nên sức mạnh...\n"+
            "Để lật lại những trang kí ức bị mất trong quá khứ.\n"+
            "Vững tin ở tâm hồn,nhìn xuyên qua bóng tối...\n"+
            "Tìm ra những linh hồn của kí ức đang ngủ sâu.\n"+
            "Và ánh mắt sắc bén cháy bóng đó,sẽ xóa tan bóng tối.\n"+
            "Hai trái tim của ánh sáng và bóng tối...\n"+
            "Hướng về phía tương lai có ánh sáng phản chiếu...\n"+
            "Giờ chúng ta hãy bước đi,...\n"+
            "Khi những đôi mắt tràn đầy màu đỏ!\n",
            "Anh lặng nghe, biển đêm mênh mang\nSóng vỗ tràn từng bờ cát trắng\nAnh chợt nghe, những âm thanh quen thuộc\nCứ ngỡ bước chân em về đây\nAnh ngồi đếm những vì sao trên cao\n"+
            "Mỗi ngôi sao là một ngày xa cách\nAnh ngồi đếm những con sóng xô bờ\nĐếm mãi sóng vẫn xô vào bờ\nCũng như anh ngồi đếm những ngày dài xa em\nCũng như anh ngồi nhớ những ngày xưa êm đềm\nNhưng sao càng đếm lại càng không thấy em\n"+
            "Nhưng sao càng nhớ lại càng xa em\nCó bao giờ con sóng không xô vào bờ không em?\nCó ai đếm hết những vì sao trên trời\nNên anh nhận ra một điều em ơi\nKhi chia tay ta rất khó quay trở về bên nhau\n",
            "Máu là máu nam nhi,mộng nam nhi là huyết mộng.\n"+
            "Tìm khắp giang hồ ai dám tranh phong,để đời đời xưng tụng anh hùng\n"+
            "Bao nhiêu tình nam nhi....dành hết cho hiệp nghĩa\n"+
            "Tận diệt chuyện bất bình chốn nhân gian.\n"+
            "Giang hồ trọng nghĩa khí!\n"+
            "Máu là máu nam nhi,mộng nam nhi là huyết mộng.\n"+
            "Tìm khắp bốn phương ai dám tranh phong,để đời đời xưng tụng anh hùng.\n"+
            "Cưỡi thần mã, dương đại cung, cõi lòng ta hào khí vạn trượng.\n"+
            "Vung trọng đao, múa linh kiếm, giữa chốn giang hồ ta là Anh Hùng...",
            "Ta tới Đại Đường mới học được một từ\n"+
            "nhưng vẫn không hiểu ý nghĩa của nó\n"+
            "không biết vị tỷ tỷ đây có thể giải đáp một chút hay không?\n"+
            "Từ này là: Phong, Hoa, Tuyết, Nguyệt\n"+
            "Việc này có gì khó?\n"+
            "Phong là xuyên qua núi, lướt nhẹ qua mặt nước mà đến\n"+
            "Hoa là rụng xuống bùn nhơ lại chẳng nhơ bẩn\n"+
            "Tuyết là ánh trắng tan trên mái hiên khi mặt trời mọc\n"+
            "Nguyệt là gần nhau trong gang tấc mà biển trời cách mặt, ngàn thu vạn năm\n"+
            "Núi cao sừng sững, du ngoạn chân trời\n"+
            "Người tới ung dung, bước đi chẳng trở ngại\n"+
            "Ngày nối tiếp đêm, lẫn lộn khó phân\n"+
            "Lúc gần lúc xa, khi tỉnh khi điên\n"+
            "Nước trong vực sâu, khi đầy khi cạn\n"+
            "Người khổ nhiều mới biết bi thương\n"+
            "Thiên địa tuần hoàn, sao mới hưng thịnh\n"+
            "Phải nhớ đừng quên, đừng quên\n"+
            "Phong là khi ngừng khi thổi căng phồng tay áo\n"+
            "Hoa là sắc ngọc lay động, bám áo không rơi\n"+
            "Tuyết là mái tóc phai sương vương trên đầu mày\n"+
            "Nguyệt là trời đêm tịch mịch vắng sao ẩn mây\n"+
            "Phong là tiếng hát trong trẻo không ngừng vang, hủy đài cao\n"+
            "Hoa là chiết nhánh trang hoàng ba trăm vần thơ\n"+
            "Tuyết là lọng trướng che trời quang, là dây cung chưa bắn\n"+
            "Nguyệt là vẻ đẹp tĩnh mịch đêm nay khó lòng trở lại\n"+
            "Thiên hạ làm cha, ta làm mẹ\n"+
            "Núi sông là phòng cưới, sao trời làm nến\n"+
            "Năm sau hóa thành vạn cốt khô\n"+
            "Sáng lập lòe hòa vào không trung\n"+
            "Phong Hoa Tuyết Nguyệt, chính là ta muốn nói với ngươi chuyện yêu đương.\n"+
            "Thiên hạ rộng lớn, buồn vui man mác\n"+
            "Gần núi cao lại nhớ sông dài\n"+
            "Cùng ý khác đường, đi ngày càng xa\n"+
            "Phong hoa tuyết nguyệt, được mấy đợt\n"+
            "Phong là giữ chặt khiên trước khói lửa vây quanh\n"+
            "Hoa là máu phun ra năm bước, giẫm xác đạp xương\n"+
            "Tuyết là da ngựa dày phủ lắp quan tài\n"+
            "Nguyệt là tâm tư khó đoán của quan chép sử ít nói\n"+
            "Phong là như lúc mới gặp, trầm ngâm bồi hồi\n"+
            "Hoa là nhân gian tháng tư, say tựa rêu xanh\n"+
            "Tuyết là nhiễm bụi hồng trần, số mệnh chia đôi\n"+
            "Nguyệt là khi tròn khi khuyết, bóng ảnh không đổi\n"+
            "Thiên hạ làm cha, ta làm mẹ\n"+
            "Núi sông là phòng cưới, sao trời làm nến\n"+
            "Năm sau hóa thành vạn cốt khô\n"+
            "Sáng lập lòe hòa vào không trung\n"+
            "Phong hoa tuyết nguyệt, chính là ta muốn cùng thiên hạ nói chuyện yêu đương.\n",
            "Có phải em về trong đêm nay , bước thấp bước cao ngã nghiêng trên đời này\n"+
            "Lạnh vai áo hoa phai màu son đôi môi nhạt nhòa , nghe buồn đau lên xót xa\n"+
            "Trang điểm cho đời vui đêm nay , chén chú chén anh rượu vơi đi lại đầy\n"+
            "Nào ai biết ai sao lại ôm nhau như người tình đôi bàn tay thú phiêu linh\n"+
            "Em gái quê nơi đồng ruộng nắng cháy , khoác xiêm y em thành người phố thị\n"+
            "Cơm áo gạo tiền xui em biết dối gian , em bước chân xuống đời làm mèo hoang\n"+
            "Có phải đêm buồn đêm lang thang , đốt cháy trái tim đời qua mau bàng hoàng\n"+
            "Ngày mai bước đi ôm nỗi đau thân phận bọt bèo , tiên đời em cũng mang theo\n"+
            "Đêm nay em về đâu , hỡi người con gái tôi thương\n"+
            "Thân em bé bỏng giữa cuộc đời\n"+
            "Anh đi tìm em , hãy quay về đây em\n"+
            "Khi màng đêm buông xuống , em biết phải làm sao ?\n"+
            "Trang điểm cho đời vui đêm nay , chén chú chén anh rượu vơi đi lại đầy\n"+
            "Nào ai biết ai sao lại ôm nhau như người tình , đôi bàn tay thú phiêu linh\n"+
            "Em gái quê nơi đồng ruộng nắng cháy , khoác xiêm y em thành người phố thị\n"+
            "Cơm áo gạo tiền xui em biết dối gian , em bước chân xuống đời làm mèo hoang\n"+
            "Có phải đêm buồn đêm lang thang , đốt cháy trái tim đời qua mau bàng hoàng\n"+
            "Ngày mai bước đi ôm nỗi đau thân phận bọt bèo , tiên đời em cũng mang theo\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textCurrentPosition = (TextView) this.findViewById(R.id.tw_position);
        this.textMaxTime = (TextView) this.findViewById(R.id.tw_maxtime);
        this.textMusic = (TextView) this.findViewById(R.id.tw_music);
        this.textSingle = (TextView) this.findViewById(R.id.tw_single);
        this.textLyric = (TextView) this.findViewById(R.id.tw_lyric);
        this.buttonStart = (Button) this.findViewById(R.id.btn_play);
        this.buttonPause = (Button) this.findViewById(R.id.btn_pause);
        this.seekBar = (SeekBar) this.findViewById(R.id.seekbar);

        this.buttonPause.setEnabled(false);
        this.seekBar.setClickable(false);

        // set Info Music current.
        setMusic(number);
        // Create MediaPlayer.
        this.mediaPlayer = MediaPlayer.create(this, songId);
    }

    private void setMusic(int number){
        songId = this.getRawResIdByName(music_Id[number]);
        this.textMusic.setText(music_Name[number]);
        this.textSingle.setText(music_Single[number]);
        this.textLyric.setText(music_Lyrics[number]);
    }

    // Find ID in raw folder follow name
    public int getRawResIdByName(String resName)  {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        return resID;
    }

    // Milli Second to String.
    private String millisecondsToString(int milliseconds)  {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds =  TimeUnit.MILLISECONDS.toSeconds((long) milliseconds) ;
        return minutes+":"+ seconds;
    }

    //When click button Play
    public void play(View view)  {
        int duration = this.mediaPlayer.getDuration();
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        if(currentPosition== 0)  {
            this.seekBar.setMax(duration);
            String maxTimeString = this.millisecondsToString(duration);
            this.textMaxTime.setText(maxTimeString);
        } else if(currentPosition== duration)  {
            this.mediaPlayer.reset();
        }
        this.mediaPlayer.start();

        UpdateSeekBarThread updateSeekBarThread= new UpdateSeekBarThread();
        threadHandler.postDelayed(updateSeekBarThread,50);

        this.buttonPause.setEnabled(true);
        this.buttonStart.setEnabled(false);
    }

    // Thread for Update SeekBar.
    class UpdateSeekBarThread implements Runnable {
        public void run()  {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            textCurrentPosition.setText(currentPositionStr);

            seekBar.setProgress(currentPosition);

            // Stop thread 50 milisecond
            threadHandler.postDelayed(this, 50);
        }
    }

    //When click button Pause
    public void pause(View view)  {
        this.mediaPlayer.pause();
        this.buttonPause.setEnabled(false);
        this.buttonStart.setEnabled(true);
    }

    //When click button Back
    public void back(View view)  {
        if(number>0)
            number--;
        else number=music_Id.length-1;
        this.mediaPlayer.reset();
        setMusic(number);
        this.mediaPlayer = MediaPlayer.create(this, songId);

       play(view);
    }

    //When click button Next
    public void next(View view)  {
        if(number<music_Id.length-1)
            number++;
        else number=0;
        this.mediaPlayer.reset();
        setMusic(number);
        this.mediaPlayer = MediaPlayer.create(this, songId);

        play(view);
    }
}
