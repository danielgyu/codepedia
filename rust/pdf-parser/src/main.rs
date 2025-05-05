fn main() {
    let pdf_path = "pdfs/attention.pdf";
    //let pdf_path = "pdfs/processes-as-files.pdf";

    let pdf_bytes = std::fs::read(pdf_path).unwrap();
    let out = pdf_extract::extract_text_from_mem(&pdf_bytes).unwrap();

    print!("[*] {}", out);
}
