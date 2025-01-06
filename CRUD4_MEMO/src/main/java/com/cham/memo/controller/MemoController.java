package com.cham.memo.controller;

import com.cham.memo.entity.Memo;
import com.cham.memo.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/index")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/memos/list")
    public String getMemoList(Model model) {
        List<Memo> memos = memoService.getAllMemo();
        model.addAttribute("memos", memos);
        // 콘텐츠로 사용할 JSP 파일 지정
        model.addAttribute("contentPage", "content.jsp");

        // 레이아웃 공통 데이터 설정
        model.addAttribute("pageTitle", "메모 리스트");
        return "layout"; // 항상 layout.jsp를 반환
    }

    @GetMapping("/memos/new")
    public String getNewMemoPage(Model model) {
        model.addAttribute("contentPage", "newMemo.jsp");
        model.addAttribute("pageTitle", "새 메모 작성");
        return "layout";
    }

    // 메모 작성 폼 페이지
    @GetMapping("/new")
    public String showCreateForm() {
        return "createMemo"; // createMemo.jsp로 이동
    }

    // 메모 생성
    @PostMapping
    public String createMemo(@RequestParam String content) {
        memoService.createMemo(content);
        return "redirect:/memos"; // 메모 리스트로 리다이렉트
    }

    // 특정 메모 조회
    @GetMapping("/{id}")
    public String getMemo(@PathVariable Long id, Model model) {
        Memo memo = memoService.getMemo(id);
        model.addAttribute("memo", memo);
        return "viewMemo"; // viewMemo.jsp로 이동
    }

    // 전체 메모 리스트 조회
    @GetMapping
    public String getAllMemo(Model model) {
        List<Memo> memos = memoService.getAllMemo();
        model.addAttribute("memos", memos);
        return "listMemo"; // listMemo.jsp로 이동
    }

    // 메모 업데이트 폼 페이지
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Memo memo = memoService.getMemo(id);
        model.addAttribute("memo", memo);
        return "editMemo"; // editMemo.jsp로 이동
    }

    // 메모 업데이트
    @PostMapping("/{id}/edit")
    public String updateMemo(@PathVariable Long id, @RequestParam String content) {
        memoService.updateMemo(id, content);
        return "redirect:/memos"; // 메모 리스트로 리다이렉트
    }

    // 메모 삭제
    @PostMapping("/{id}/delete")
    public String deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return "redirect:/memos"; // 메모 리스트로 리다이렉트
    }
}
