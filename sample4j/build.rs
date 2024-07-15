use std::process::Command;

// build.rs
fn main() {
    //call shell
    println!("cargo:rerun-if-changed=src/main/java");
    println!("cargo:rerun-if-changed=src/main/resources");
    println!("cargo:rerun-if-changed=src/test/java");
    println!("cargo:rerun-if-changed=src/test/resources");
    match Command::new("bash").args(["build_java.sh"]).spawn() {
        Ok(child) => match child.wait_with_output() {
            Ok(output) => {
                println!("Exit status: {}", output.status);
                if output.status.success() {
                    println!("{}", String::from_utf8_lossy(&output.stdout));
                } else {
                    panic!("failed to call shell to build java{}", String::from_utf8_lossy(&output.stderr));
                }
            }
            Err(e) => panic!("failed to execute process: {}", e),
        },
        Err(_) => panic!("failed to execute process"),
    }
}
