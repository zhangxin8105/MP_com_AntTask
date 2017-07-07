/**
 * Copyright 2016 - Zhang Xin
 *
 * Date: 2016年11月18日  上午10:28:24
 */

package zhangxin.ant.task;

import org.apache.tools.ant.BuildException;

import zhangxin.ant.task.run.InputRun;
import zhangxin.ant.task.run.StudyDirectoryChooser;

/**
 * @author Zhang Xin
 *
 */
public class ZhxInput extends org.apache.tools.ant.Task {
    /* (non-Javadoc)
     * @see org.apache.tools.ant.Task#execute()
     */
    @Override
    public void execute() throws BuildException {
        System.out.println("zhangxinaaaa");
        System.out.println(getProject().getProperty("zhangxin"));

        getProject().setProperty("zhangxin", "zhangjingyi");
        System.out.println(getProject().getProperty("zhangxin"));

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("1 zhangxinaaaa");
                // InputRun inputRun = new InputRun();
                StudyDirectoryChooser.main(null);

                int i = 0;
                while (true) {
                    // if (!inputRun.isShowing()) break;
                    System.out.println("wait" + i++);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // System.out.println("2 zhangxinaaaa");
            }
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3 zhangxinaaaa");
    }
}
