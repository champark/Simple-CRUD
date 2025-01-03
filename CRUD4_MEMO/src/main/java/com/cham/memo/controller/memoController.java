package com.cham.memo.controller;

import com.cham.memo.entity.Memo;
import com.cham.memo.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
public class memoController {

    private final MemoService memoService;

    public memoController(MemoService memoService) {
        this.memoService = memoService;
    }

    // 만들기
    @PostMapping
    public Memo createMemo(@RequestBody String content) {
        return memoService.createMemo(content);
    }

    // 조회
    @GetMapping("/{id}")
    public Memo getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }

    // 다조회
    @GetMapping
    public List<Memo> getAllMemo() {
        return memoService.getAllMemo();
    }

    // 업데이트
    @PutMapping("/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody String content) {
        return memoService.updateMemo(id,content);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
    }
}
