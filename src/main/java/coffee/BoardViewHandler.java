package coffee;

import coffee.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BoardViewHandler {


    @Autowired
    private BoardRepository boardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRequested_then_CREATE_1 (@Payload Requested requested) {
        try {
            if (requested.isMe()) {
                // view 객체 생성
                Board board = new Board();
                // view 객체에 이벤트의 Value 를 set 함
                board.setRequestId(requested.getRequestId());
                board.setStatus(requested.getStatus());
                board.setMenuId(requested.getMenuId());
                board.setPrice(requested.getPrice());
                board.setCnt(requested.getCnt());
                board.setStorageStatus(requested.getStatus());
                // view 레파지 토리에 save
                boardRepository.save(board);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_UPDATE_1(@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 조회
                List<Board> boardList = boardRepository.findByRequestId(ordered.getRequestId());
                for( Board board : boardList) {                

                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    board.setStatus(ordered.getStatus());
                    board.setOrderMethod(ordered.getOrderMethod());
                    board.setOrderTime(ordered.getOrderTime());
                    board.setStorageStatus(ordered.getStatus());                    
                    // view 레파지 토리에 save
                    boardRepository.save(board);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMade_then_UPDATE_2(@Payload Made made) {
        try {
            if (made.isMe()) {
                // view 객체 조회
                List<Board> boardList = boardRepository.findByRequestId(made.getRequestId());
                for( Board board : boardList) {

                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    board.setStatus(made.getStatus());
                    board.setMakeStaff(made.getMakeStaff());
                    board.setMakeTime(made.getMakeTime());
                    board.setStorageStatus(made.getStatus());
                    // view 레파지 토리에 save
                    boardRepository.save(board);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenNotified_then_UPDATE_3(@Payload Notified notified) {
        try {
            if (notified.isMe()) {
                // view 객체 조회
                List<Board> boardList = boardRepository.findByRequestId(notified.getRequestId());
                for( Board board : boardList) {

                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    board.setStatus(notified.getStatus());
                    board.setNotifyTime(notified.getNotifyTime());
                    board.setStorageStatus(notified.getStatus());
                    // view 레파지 토리에 save
                    boardRepository.save(board);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMakeCanceled_then_UPDATE_4(@Payload MakeCanceled makeCanceled) {
        try {
            if (makeCanceled.isMe()) {
                // view 객체 조회
                List<Board> boardList = boardRepository.findByRequestId(makeCanceled.getRequestId());
                for( Board board : boardList) {

                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    board.setStatus(makeCanceled.getStatus());
                    board.setCancelTime(makeCanceled.getCancelTime());
                    board.setStorageStatus(makeCanceled.getStatus());
                    // view 레파지 토리에 save
                    boardRepository.save(board);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}