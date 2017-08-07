package startsmart.base.model.general;

import java.io.OutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjeev on 07/08/17.
 */
public class MultiplePrintStream extends PrintStream
{
        private PrintStream[] allStreams = null;

        public MultiplePrintStream(PrintStream... streams)
        {
            super((OutputStream) null);
            if(streams == null)
            {
                throw new InvalidParameterException("Streams cannot be null");
            }
            allStreams = streams;
        }

        public void flush()
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try {
                    stream.flush();
                }
                catch(Exception e) {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void close()
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try {
                    stream.close();
                }
                catch(Exception e) {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public boolean checkError()
        {
            List<Exception> exceptions = new ArrayList<>();
            boolean status = true;
            for(PrintStream stream : allStreams)
            {
                try {
                    status  = status && stream.checkError();
                }
                catch(Exception e) {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty()){
                MultipleException me = new MultipleException(exceptions);
                me.setReturnData(status);
                throw me;
            }
            return status;
        }

        public void write(int b)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.write(b);
                }
                catch(Exception e)
                {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void write(byte buf[], int off, int len)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.write(buf,off,len);
                }
                catch(Exception e)
                {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }
        public void print(boolean b)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(b);
                }
                catch(Exception e)
                {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }
        public void print(char c)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(c);
                }
                catch(Exception e)
                {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }
        public void print(int i)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(i);
                }
                catch(Exception e)
                {
                    exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }
        public void print(long l)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(l);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }
        public void print(float f)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(f);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }
        public void print(double d)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(d);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void print(char s[])
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(s);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void print(String s)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(s);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void print(Object obj)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.print(obj);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println()
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println();
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(boolean x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(char x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(int x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(long x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(float x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(double x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(char x[])
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(String x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }

        public void println(Object x)
        {
            List<Exception> exceptions = new ArrayList<>();
            for(PrintStream stream : allStreams)
            {
                try
                {
                    stream.println(x);
                }
                catch(Exception e)
                {
                   exceptions.add(e);
                }
            }
            if(!exceptions.isEmpty())
                throw new MultipleException(exceptions);
        }
}
