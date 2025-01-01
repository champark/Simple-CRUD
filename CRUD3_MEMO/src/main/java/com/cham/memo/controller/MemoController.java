package com.cham.memo.controller;

import com.cham.memo.entity.Memo;
import com.cham.memo.service.MemoService;
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

    @GetMapping("/{id}")
    public Memo get1Memo(@PathVariable Long id) {
        return memoService.getOneMemo(id);
    }

    @GetMapping
    public List<Memo> getAllMemos() {
        return memoService.getAllMemos();
    }

    @PutMapping("/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody String content) {
        return memoService.updateMemo(id, content);
    }

    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
    }
}
