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

    public Memo createMemo(String content) {
        Memo memo = new Memo();
        memo.setContent(content);
        return memoRepository.save(memo);
    }

    public Memo getOneMemo(Long id) {
        return memoRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("메모가 없네요!"));
    }

    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    public Memo updateMemo(Long id, String newContent) {
        Memo memoToUpdate = getOneMemo(id);
        memoToUpdate.setContent(newContent);
        return memoRepository.save(memoToUpdate);
    }

    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }
}
