# 🔥 liquibase-extension-example

Example repository for creating your own Liquibase CORE and Liquibase PRO extensions.  
This repository uses the reusable workflows from the [liquibase/build-logic](https://github.com/liquibase/build-logic) repository. 🚀

🔐 **Secrets** required for extensions using this template are documented in our infrastructure repository [here](https://github.com/liquibase/liquibase-infrastructure/blob/master/github/README.md).  

---

### 🛠️ Modify `test.yml` as per your requirement

✅ **OSS-Extension**: use the reusable workflow block below:
```yaml
uses: liquibase/build-logic/.github/workflows/os-extension-test.yml@v0.5.3
```

✅ **PRO-Extension** : use the below reusable workflow block :  
```yaml
uses: liquibase/build-logic/.github/workflows/pro-extension-test.yml@v0.5.5
```
