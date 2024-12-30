package com.example.memo.controller;

import com.example.memo.entity.Memo;
import com.example.memo.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public Memo createMemo(@RequestBody String content) {
        return memoService.createMemo(content);
    }

    @GetMapping
    public List<Memo> getAllMemos() {
        return memoService.getAllMemos();
    }

    @GetMapping("/{id}")
    public Memo getMemoById(@PathVariable Long id) {
        return memoService.getMemoById(id);
    }

    @PutMapping("/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody String newContent) {
        return memoService.updateMemo(id, newContent);
    }

    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
    }
}
