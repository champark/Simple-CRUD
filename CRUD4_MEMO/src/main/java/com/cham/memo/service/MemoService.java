package com.cham.memo.service;

import com.cham.memo.entity.Memo;
import com.cham.memo.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // 생성
    public Memo createMemo(String content) {
        Memo memo = new Memo();
        memo.setContent(content);
        return memoRepository.save(memo);
    }

    // 조회
    public Memo getMemo(Long id) {
        return memoRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("메모가 없네요!"));
    }

    // 다 조회
    public List<Memo> getAllMemo() {
        return memoRepository.findAll();
    }

    // 업데이트
    public Memo updateMemo(Long id, String newContent) {
        Memo memo = getMemo(id);
        memo.setContent(newContent);
        return memoRepository.save(memo);
    }

    // 삭제
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }
}
