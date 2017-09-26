package com.phamluu.script_executor;


public class TestXStream {

    public static void main(String[] args) {
        Action act1 = new MouseClick();
        act1.setX(100);
        act1.setY(100);
        act1.setAfterActionPause(100);
        act1.setDescription(" very first Action");

        ActionScript actionScript = new ActionScript();
        actionScript.setDescription("My first Action Script");
        actionScript.getActionList().add(act1);

        //        Blog teamBlog = new Blog(new Author("Guilherme Silveira"));
        //        teamBlog.add(new Entry("first","My first blog entry."));
        //        teamBlog.add(new Entry("tutorial",
        //                "Today we have developed a nice alias tutorial. Tell your friends! NOW!"));

        //        XStream xstream = new XStream();
        //        System.out.println(xstream.toXML(actionScript));

    }

}
