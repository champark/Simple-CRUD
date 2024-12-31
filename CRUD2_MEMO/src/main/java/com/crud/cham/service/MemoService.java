package com.crud.cham.service;

import com.crud.cham.entity.Memo;
import com.crud.cham.repository.MemoRepository;
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

    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    public Memo getMemoById(Long id) {
        return memoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("메모가 없네요!"));
    }

    public Memo updateMemo(Long id, String newContent) {
        Memo memo = getMemoById(id);
        memo.setContent(newContent);
        return memoRepository.save(memo);
    }

    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }
}
