package app.reserv;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AppService;
import app.AppView;
import dao.DAO;
import dao.SeatDAO;
import dao.TicketDAO;
import entity.PayDTO;
import entity.SeatDTO;
import entity.TicketDTO;
import gui.Gui;

public class CompletePay extends AppView{
   private TicketDTO ticket;
//   private PayDTO pay;
   private Reservation reserv;
   private JPanel jpanel;
   private Vector<String> seatsNumber;
   private TicketDAO ticketDao;
   private PayDTO pay;
   private SeatDAO sDao;
   
   public CompletePay(Reservation reserv) {
	   super("티켓 결제 완료",reserv);
	   this.reserv = reserv;
   }
   public void completep(TicketDTO ticket, Vector<String> seatsNumber, int cost) {
      rootPanel.removeAll();
      rootPanel.setLayout(null);
      rootPanel.setBounds(0,0,1000,1000);
      rootPanel.setBackground(Color.white);
      this.ticket = ticket;
      
      this.seatsNumber = seatsNumber;
      
      JPanel panel = new JPanel();
      panel.setForeground(new Color(255, 255, 255));
      panel.setBounds(0, 0, 710, 600);
      rootPanel.add(panel);
      panel.setLayout(null);
      
      JLabel name = new JLabel("이 름");
      name.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      name.setBounds(62, 40, 72, 55);
      panel.add(name);
      
      JLabel rdate = new JLabel("예약일");
      rdate.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      rdate.setBounds(309, 40, 72, 55);
      panel.add(rdate);
      
      JLabel sgrade = new JLabel("좌석 등급");
      sgrade.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      sgrade.setBounds(62, 105, 72, 55);
      panel.add(sgrade);
      
      JLabel snumber = new JLabel("좌석 번호");
      snumber.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      snumber.setBounds(62, 180, 72, 55);
      panel.add(snumber);
      
      JLabel depplace = new JLabel("출발지");
      depplace.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      depplace.setBounds(62, 257, 72, 55);
      panel.add(depplace);
      
      JLabel depdate = new JLabel("출발일");
      depdate.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      depdate.setBounds(309, 257, 57, 55);
      panel.add(depdate);
      
      
      JLabel arrplace = new JLabel("도착지");
      arrplace.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      arrplace.setBounds(62, 340, 72, 55);
      panel.add(arrplace);
      JLabel arrdate = new JLabel("도착일");
      arrdate.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      arrdate.setBounds(309, 340, 72, 55);
      panel.add(arrdate);
      
      JLabel humancnt = new JLabel("인 원");
      humancnt.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      humancnt.setBounds(62, 438, 72, 55);
      panel.add(humancnt);
      
      JLabel adult = new JLabel("성 인");
      adult.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      adult.setBounds(146, 438, 72, 55);
      panel.add(adult);
      
      JLabel kid = new JLabel("소 아");
      kid.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      kid.setBounds(309, 438, 72, 55);
      panel.add(kid);
      
      JLabel price = new JLabel("금 액");
      price.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      price.setBounds(309, 537, 57, 55);
      panel.add(price);
      
      JLabel name_1 = new JLabel(ticket.getCustomerName());
      name_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      name_1.setBounds(146, 40, 106, 55);
      panel.add(name_1);
      
      JLabel rdate_1 = new JLabel(ticket.getReserveDate());
      rdate_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      rdate_1.setBounds(396, 40, 180, 55);
      panel.add(rdate_1);
      
      JLabel sgrade_1 = new JLabel(ticket.getSeatGrade());
      sgrade_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      sgrade_1.setBounds(146, 105, 133, 55);
      panel.add(sgrade_1);
      
      JLabel snumber_1 = new JLabel(seatsNumber.toString());
      snumber_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      snumber_1.setBounds(146, 180, 317, 55);
      panel.add(snumber_1);
      
      JLabel depplace_1 = new JLabel(ticket.getDepPlace());
      depplace_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      depplace_1.setBounds(146, 257, 159, 55);
      panel.add(depplace_1);
      
      JLabel depdate_1 = new JLabel(ticket.getDepDate());
      depdate_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      depdate_1.setBounds(396, 257, 180, 55);
      panel.add(depdate_1);
      
      JLabel arrplace_1 = new JLabel(ticket.getArrPlace());
      arrplace_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      arrplace_1.setBounds(146, 340, 159, 55);
      panel.add(arrplace_1);
      
      JLabel arrdate_1 = new JLabel(ticket.getArrDate());
      arrdate_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      arrdate_1.setBounds(393, 340, 180, 55);
      panel.add(arrdate_1);
      
      JLabel adult_1 = new JLabel(String.valueOf(ticket.getAdultCnt()));
      adult_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      adult_1.setBounds(230, 438, 72, 55);
      panel.add(adult_1);
      
      JLabel kid_1 = new JLabel(String.valueOf(ticket.getKidCnt()));
      kid_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      kid_1.setBounds(393, 438, 72, 55);
      panel.add(kid_1);
      
      JLabel price_1 = new JLabel(String.valueOf(cost));
      price_1.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
      price_1.setBounds(396, 534, 190, 60);
      panel.add(price_1);
      
      
      JButton complete = new JButton("완    료");
      complete.setFont(new Font("맑은 고딕",Font.PLAIN, 18));
      complete.setBounds(500, 500, 100, 53);
      panel.add(complete);
      
      complete.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            AppService.instance().removeSubApp(reserv);
            AppService.instance().addSubApp(new Reservation());
            AppService.instance().updateSubAppIcons();
         }
      });
   }
   
   public static void main(String[] args) {
      CompletePay p = new CompletePay(new Reservation());
      TicketDTO t = new TicketDTO("aaa","aaa","aaa","123213", "123213","123213","123213","123213","123213","123213","123213",10000,2,1);
      p.completep(t, new Vector<String>(Arrays.asList(new String[]{"A1","B1","C1"})), 10000);
      Gui.createFrame(p.getPanel()).setSize(1000,1000);
   }

   @Override
   public void initRootPanel() {
      // TODO Auto-generated method stub
   }
}
